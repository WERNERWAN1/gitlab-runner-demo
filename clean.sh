# !/bin/bash
#获取端口占用
p_pid=$(netstat -npta | grep 8803)
echo $p_pid
#字符串分割成数组
array=(${p_pid//' '/ })

if [ -n "${array[6]}" ];then
#获取端口和程序
        str2=${array[6]}
        array2=(${str2//'/'/ })
#杀掉线程
        kill -9 ${array2[0]}
fi
exit $?
