grep '含有敏感词的用户ID'  cms-logFile.2018-06-28.0.log | cut -nb 114- > signature.txt

## 114-:从低114个字节开始，到最后，注意如果文件编码格式是UTF-8，一个汉字占三个字节。