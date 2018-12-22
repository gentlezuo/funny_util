# encode  
## 介绍
编码解码的小程序，可以对所有字符串进行有趣的编码解码  
使用`天地玄黄宇宙洪荒日月盈昃辰宿列张子丑寅卯辰巳午未申酉戌亥乾坎艮震巽离坤兑`编码   
使用java语言  

## 关于编码
有很多常用的编码方式：
* ascll编码：国际标准有128位，采用一字节存储，包括了数字大小写字母以及一些特殊功能的编码，扩充的有256位，但非国际标准，显然不支持中文以及其他很多字符
* gbk编码，属于中国人的编码，支持中日韩汉字，采用两字节存储，可以存几万个中文字符
* ISO-8859-1编码，是单字节编码，向下兼容ASCII
* Unicode码，它为每种语言中的每个字符设定了统一并且唯一的二进制编码，以满足跨语言、跨平台进行文本转换、处理的要求，采用多字节存储，但是对于英文会显得比较浪费
* utf-8编码，向下兼容ascll码，采用单字节到多字节的编码方式，英文采用单字节，中文是三字节。至于怎么识别，它有一套自己的规范：对于单个字节的字符，第一位设为 0，后面的 7 位对应这个字符的 Unicode 码点。因此，对于英文中的 0 - 127 号字符，与 ASCII 码完全相同。   
对于需要使用 N 个字节来表示的字符（N > 1），第一个字节的前 N 位都设为 1，第 N + 1 位设为0，剩余的 N - 1 个字节的前两位都设位 10，剩下的二进制位则使用这个字符的 Unicode 码点来填充。

## 关于翻译
使用[百度翻译api接口](http://api.fanyi.baidu.com/api/trans/product/index)   