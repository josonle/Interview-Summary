### 查找并杀死某个进程

以网易云(netease-cloud-music)为例

kill -9 \`ps aux | grep cloud-music | grep -v grep | awk '{print $2}'\`



### 查找某段时间内修改过的文件并删除

以删除修改时间超过三天，目录/tmp下为例

`find /tmp -mtime +3 -name '*.txt' -exec rm {} \;` 

- `-name`是按文件名查找，后面如果要用正则就得用引号括起
- `-exec command {} \;`是对搜索结果做系列操作（执行一个命令），别忘记空格和分号
- `-size`是根据文件大小查找，G、M、k、c分别代表GB、MB、KB、字节
- 通过时间来查找
  - Access time 上一次文件读或者写的时间，`-mtime	-mmin`，time代表天，min代表分钟
    - `-mtime +3`修改时间超过3天，`-mtime -2`修改时间小于2天
    - `-mmin +60`修改时间超过1小时，其余类似，下面也如此
  - Modifica time 上一次文件被修改的时间，`-atime  -amin`
  - Change time 上一次文件 inode meta 信息被修改的时间，`-ctime  -cmin`

- `-user/group`通过用户/组查找

- `-mindepth/maxdepth` 限定查找深度