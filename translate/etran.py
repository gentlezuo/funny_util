import hashlib
import http.client
import json
import random
import urllib
appid=''#自己的appid
secretKey=''#自己的key

def baidu_tran(content):
    appid=''
    secretKey=''
    httpClient=None
    myurl='/api/trans/vip/translate'#基础url
    q=content#输入的内容
    fromLang='en'
    toLang='zh'
    salt=random.randint(32768,65536)
    sign=appid+q+str(salt)+secretKey
    sign=hashlib.md5(sign.encode()).hexdigest()
    myurl=myurl+'?appid='+appid+'&q='+urllib.parse.quote(q)+'&from='+fromLang+'&to='+toLang+'&salt='+str(salt)+'&sign='+sign
    try:
        #连接
        httpClient=http.client.HTTPConnection('api.fanyi.baidu.com')
        httpClient.request('POST',myurl)
        response=httpClient.getresponse()
        #print(response)
        jsonResponse=response.read().decode('utf-8')
        js=json.loads(jsonResponse)
        #print(js)
        dst=str(js["trans_result"][0]["dst"])
        print(dst)
    except Exception as e:
        print(e)
    finally:
        if(httpClient):
            httpClient.close()

baidu_tran(input())
