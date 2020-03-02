pushd ./docker

docker network remove scala-study
docker network create scala-study

docker-compose build
docker-compose up -d
