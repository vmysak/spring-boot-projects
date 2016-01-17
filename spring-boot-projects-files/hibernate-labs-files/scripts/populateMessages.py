import urllib2
import random
import string


def randomword(length):
    return ''.join(random.choice(string.lowercase) for i in range(length))


for i in range(1, 100):
    data = '{"author": "author%s","text": "%s"}'
    url = 'http://127.0.0.1:8812/hibernate-labs/api/message/save'
    req = urllib2.Request(url, data % (i, randomword(10)), {'Content-Type': 'application/json'})
    f = urllib2.urlopen(req)
    for x in f:
        print(x)
    f.close()
