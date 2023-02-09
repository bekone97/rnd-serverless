#!/bin/sh
set -e

docker build -f docker/graalvm.Dockerfile -t al2-graalvm:maven .
docker build -f docker/native.Dockerfile -t al2-graalvm:native .
docker build -f docker/quarkus.Dockerfile -t al2-graalvm:quarkus .