import logging
import requests
import inspect
import json

class SpotifyWebAPITests:
    # base URL of all Spotify API endpoints
    BASE_URL = 'https://api.spotify.com/v1/'

    # Track ID from the URI
    track_id = '65HLjHSipFfvIU3082WFmS?si=21bdd6d3701b4c2e'
    CLIENT_ID = 'SECRET ID'
    CLIENT_SECRET = 'SECRET'

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


if __name__ == '__main__':
    webApi = SpotifyWebAPITests()
    logger = logging.getLogger()

    # actual GET request with proper header
    r = requests.get(webApi.BASE_URL + 'audio-features/' + webApi.track_id, headers=webApi.headers)

    r = r.json()

    logger = logging.getLogger()
    logger.info(r)
    print(r)