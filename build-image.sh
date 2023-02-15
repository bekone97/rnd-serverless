#!/bin/sh
set -e

docker build -f docker/graalvm11.Dockerfile -t al2-graalvm:11 .
docker build -f docker/graalvm17.Dockerfile -t al2-graalvm:17 .

docker build -f docker/native.Dockerfile -t al2-graalvm:native .
docker build -f docker/quarkus.Dockerfile -t al2-graalvm:quarkus .
docker build -f docker/spring.Dockerfile -t al2-graalvm:spring .
docker build -f docker/micronaut.Dockerfile -t al2-graalvm:micronaut .