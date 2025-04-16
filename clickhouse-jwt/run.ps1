Set-Location src
docker-compose down -v
docker-compose pull
docker-compose build
docker-compose up -d
Set-Location ..