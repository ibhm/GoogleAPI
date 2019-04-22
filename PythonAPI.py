import googlemaps
from datetime import datetime

gmaps = googlemaps.Client(key='AIzaSyCiNoDpre_XOIgY4dW1_8-IRu4H70-GXrA')

# Geocoding an address
geocode_result = gmaps.geocode('3301 South Michigan Avenue Chicago IL, 60616')


