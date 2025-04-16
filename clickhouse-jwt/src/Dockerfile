FROM openresty/openresty:alpine

RUN apk add --no-cache \
    openssl-dev \
    gcc \
    musl-dev \
    lua5.1 \
    luarocks5.1 && \
    luarocks-5.1 install lua-resty-jwt

COPY nginx.conf /usr/local/openresty/nginx/conf/nginx.conf
COPY public_key.pem /etc/public_key.pem

RUN chmod 644 /etc/public_key.pem

CMD ["/usr/local/openresty/bin/openresty", "-g", "daemon off;"]