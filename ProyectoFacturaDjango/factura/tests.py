import json

from django.test import TestCase
import requests, json


class TestCase(TestCase):

    def test_api(self):
        ts = 1
        private_key = "faa0313d78d5dc75a5c21cd9a10322dea78633ec"
        public_key = "e62cba377e616fcc381c12dd67e4f4f7"
        hashed = "0828b588b9a67f9a02c6381f0a39de44"
        url = "https://gateway.marvel.com:443/v1/public/characters?apikey=e62cba377e616fcc381c12dd67e4f4f7&hash=0828b588b9a67f9a02c6381f0a39de44&ts=1"
        response = requests.get(url)
        print(url)
        print(response)

    def test_json_api(self):
        url = "https://gateway.marvel.com:443/v1/public/characters?apikey=e62cba377e616fcc381c12dd67e4f4f7&hash=0828b588b9a67f9a02c6381f0a39de44&ts=1"
        response = requests.get(url)
        if response.status_code == 200:
            response_json = json.loads(response.text)
            print(response_json["data"]["results"])
