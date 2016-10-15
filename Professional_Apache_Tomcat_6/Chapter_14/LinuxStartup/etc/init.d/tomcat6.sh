#!/bin/bash
RETVAL=$?
export JAVA_HOME=/usr/java/jdk160
export CATALINA_HOME=/usr/local/tomcat6

case “$1” in
 start)
        if [ -f $CATALINA_HOME/bin/startup.sh ];
          then
            echo $”Starting Tomcat”
            /bin/su tomcat $CATALINA_HOME/bin/startup.sh
        fi
        ;;
 stop)
        if [ -f $CATALINA_HOME/bin/shutdown.sh ];
          then
            echo $”Stopping Tomcat”
            /bin/su tomcat $CATALINA_HOME/bin/shutdown.sh
        fi
        ;;
 *)
        echo $”Usage: $0 {start|stop}”
        exit 1
        ;;
esac

exit $RETVAL
