#!/usr/bin/env sh

LOCAL_CLASSPATH=""

for file in lib/*.jar; do
    if [ -f "$file" ]; then
        LOCAL_CLASSPATH=$LOCAL_CLASSPATH:$file
    fi
done

java -cp $LOCAL_CLASSPATH middleman/Console $*
