import spotipy
from spotipy.oauth2 import SpotifyClientCredentials

# Spotify Developer Dashboardから取得したClient IDとClient Secretを設定
client_id = '2960e30f794e493b9d05247ac1d70eea'
client_secret = '0ca903025dd64482a5c8122c175d2675'

# Spotipyを初期化
sp = spotipy.Spotify(auth_manager=SpotifyClientCredentials(client_id=client_id, client_secret=client_secret))

# Spotify APIを使用してプレイリスト情報を取得
def get_playlist_info(playlist_id):
    try:
        playlist = sp.playlist(playlist_id)
        # プレイリスト情報を利用する処理を追加
        print("Playlist Name:", playlist['name'])
        print("Number of Tracks:", playlist['tracks']['total'])
        for track in playlist['tracks']['items']:
            print("Track Name:", track['track']['name'])
            print("Artist(s):", ", ".join([artist['name'] for artist in track['track']['artists']]))
    except Exception as e:
        print("Error:", str(e))

# メイン関数
if __name__ == "__main__":
    playlist_id = '37i9dQZF1DWXRqgorJj26U'  # 取得したいプレイリストのIDを指定
    get_playlist_info(playlist_id)
