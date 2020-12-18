#!/bin/bash

while true; do
  sleep $(( 1 + $RANDOM%10))
  curl --no-keepalive http://localhost/chance
done

