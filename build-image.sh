#!/bin/sh
set -e

docker build -f Dockerfile.native -t al2-graalvm:maven .