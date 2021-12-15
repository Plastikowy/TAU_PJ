import requests
import inspect
import json

class SpotifyWebAPITests:
    # base URL of all Spotify API endpoints
    BASE_URL = 'https://api.spotify.com/v1/'

    # Track ID from the URI
    track_id = '65HLjHSipFfvIU3082WFmS?si=21bdd6d3701b4c2e'
    CLIENT_ID = 'SECRET_CLIENT_ID'
    CLIENT_SECRET = 'SECRET_CLIENT_SECRET'

    AUTH_URL = 'https://accounts.spotify.com/api/token'
    headers = None

    def __init__(self):
        # POST
        auth_response = requests.post(self.AUTH_URL, {
            'grant_type': 'client_credentials',
            'client_id': self.CLIENT_ID,
            'client_secret': self.CLIENT_SECRET,
        })

        # convert the response to JSON
        auth_response_data = auth_response.json()

        # save the access token
        access_token = auth_response_data['access_token']

        self.headers = {
            'Authorization': 'Bearer {token}'.format(token=access_token)
        }

    def assertion(self, given, expected) -> bool:
        try:
            assert given == expected
            return True
        except AssertionError:
            return False

    def print_test(self, testname, result):
        if result:
            print(testname + ': passed')
        else:
            print(testname + ': failed')

    def test_if_requests_gets_OK(self):
        result = requests.get(webApi.BASE_URL + 'audio-features/' + webApi.track_id, headers=webApi.headers).status_code

        assertion = self.assertion(result, 200)
        self.print_test(inspect.stack()[0][3], assertion)

    def test_if_requests_gets_BAD_REQUEST(self):
        result = requests.get(webApi.BASE_URL + 'audio-features/12312312asfdksoafdpkosak',headers=webApi.headers).status_code

        assertion = self.assertion(result, 400)
        self.print_test(inspect.stack()[0][3], assertion)

    def test_if_requests_gets_NOT_FOUND(self):
        result = requests.get(webApi.BASE_URL + 'dabadabadu',headers=webApi.headers).status_code

        assertion = self.assertion(result, 404)
        self.print_test(inspect.stack()[0][3], assertion)

    def test_get_artist_name(self):
        result = requests.get(webApi.BASE_URL + 'artists/6lp2VnIRXXpC9Wz7hSX6RE?si=41a30e18a02e496e', headers=webApi.headers)
        result = result.json()['name']

        assertion = self.assertion(result, 'Culture Shock')
        self.print_test(inspect.stack()[0][3], assertion)

    def test_get_song_tempo(self):
        result = requests.get(webApi.BASE_URL + 'audio-features/' + webApi.track_id, headers=webApi.headers)
        result = result.json()['tempo']

        assertion = self.assertion(result, 173.986)
        self.print_test(inspect.stack()[0][3], assertion)


if __name__ == '__main__':
    webApi = SpotifyWebAPITests()

    # actual GET request with proper header
    # r = requests.get(webApi.BASE_URL + 'audio-features/' + webApi.track_id, headers=webApi.headers)
    # r = r.json()
    # print(r)

    webApi.test_if_requests_gets_OK()
    webApi.test_if_requests_gets_BAD_REQUEST()
    webApi.test_get_artist_name()
    webApi.test_if_requests_gets_NOT_FOUND()
    webApi.test_get_song_tempo()