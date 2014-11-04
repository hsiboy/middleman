#!/bin/bash

ANT_HOME=$PWD/tools/apache-ant-1.8.3
export ANT_OPTS=-Xmx1024m

$ANT_HOME/bin/ant -lib lib/build -lib lib/test $@

ANT_STATUS=$?

if [ -n "$CC_BUILD_ARTIFACTS" ]; then
    # We're running in CC.rb, let's publish some build artefacts
    echo "Publishing CC.rb artefacts"
    rsync -a $PWD/build/reports/html/ $CC_BUILD_ARTIFACTS
fi

exit $ANT_STATUS

