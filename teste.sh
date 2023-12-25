#!/bin/sh

mensagem= docker images --filter=reference='tasks-backend:1.0.0'



echo "A mensagem é: $mensagem"