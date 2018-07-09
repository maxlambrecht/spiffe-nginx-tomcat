#!/usr/bin/env bash
name="$1"
id="$2"
adduser --uid ${id} --disabled-password --gecos "" ${name}
