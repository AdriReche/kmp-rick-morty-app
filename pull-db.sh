#!/usr/bin/env bash
pkg="org.arexdev.rickmortyapp"
db="rm_app_database.db"

for suf in "" "-wal" "-shm"; do
  adb exec-out run-as "$pkg" \
    cat "databases/$db$suf" > "$db$suf"
done