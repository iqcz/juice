#!/bin/bash

ps -Leo pid, lwp, user, pcpu, pmem, cmd >> /tmp/pthreads.log
echo "ps -Leo pid, lwp, user, pcpu, pmem, cmd >> /tmp/pthreads.log" >> /tmp/pthreads.log

echo `date` >> /tmp/pthreads.log
echo 1

pid = `ps aux | grep tomcat | grep cwh | awk -F ' ' ' {print $2}'`
echo 2

echo "pstack $pid >> /tmp/pstack.log" >> /tmp/pstack.log
pstack $pid >> /tmp/pstack.log
echo `date` >> /tmp/pstack.log

