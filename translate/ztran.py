import hashlib
import http.client
import json
import random
import urllib
appid=''
secretKey=''

def baidu_tran(content):
    appid='20181222000251106'
    secretKey='tU78OuVzBgT2aWe43yiy'
    httpClient=None
    myurl='/api/trans/vip/translate'
    q=content
    fromLang='zh'
    toLang='en'
    salt=random.randint(32768,65536)
    sign=appid+q+str(salt)+secretKey
    sign=hashlib.md5(sign.encode()).hexdigest()
    myurl=myurl+'?appid='+appid+'&q='+urllib.parse.quote(q)+'&from='+fromLang+'&to='+toLang+'&salt='+str(salt)+'&sign='+sign
    try:
        httpClient=http.client.HTTPConnection('api.fanyi.baidu.com')
        httpClient.request('POST',myurl)
        #得到响应
        response=httpClient.getresponse()
        #
        jsonResponse=response.read().decode('utf-8')
        js=json.loads(jsonResponse)
        #{'from': 'zh', 'to': 'en', 'trans_result': [{'src': '你好', 'dst': 'Hello'}]}
        dst=str(js["trans_result"][0]["dst"])
        print(dst)
    except Exception as e:
        print(e)
    finally:
        if(httpClient):
            httpClient.close()


baidu_tran(input())