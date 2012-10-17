#!/bin/bash

denominator=`ls -1 ch*/*/README.md | wc -l`
numerator=`ls -1 ch*/*/*.java | sed 's$\(.*\)\(/.*\.java\)$\1$g' | uniq | wc -l`


result=`expr $((numerator)) / $((denominator))`

echo $((numerator)) / $((denominator))

echo "`echo "scale=2; $((numerator)).0 * 100 / $((denominator)).0 " | bc`%"


TMP=/tmp/JPLlist.dat
ls -1 ch*/*/README.md | sed 's$\(.*\)\(/.*\.md\)$\1$g' > $TMP
ls -1 ch*/*/*.java | sed 's$\(.*\)\(/.*\.java\)$\1$g' | uniq | diff - $TMP | awk 'NF > 1 {print $2;}'
rm -f $TMP

