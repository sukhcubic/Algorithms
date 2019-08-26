#!/usr/bin/python
## use:
## python send-udp.py targetsystem targetport
## script reads from sample.csv and sends data


import socket
import sys  

#HOST = '192.168.16.22'  # The server's hostname or IP address
HOST = '64.124.123.52'
PORT = 40921        # The port used by the server

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server_address = (HOST, PORT)
message = '>RPV05580+2980993-0953172500000032;ID=0056<'

try:

    # Send data
    print >>sys.stderr, 'sending "%s"' % message
    sent = sock.sendto(message, server_address)

    # Receive response
    print >>sys.stderr, 'waiting to receive'
    data, server = sock.recvfrom(4096)
    print >>sys.stderr, 'received "%s"' % data

finally:
    print >>sys.stderr, 'sent'
    sock.close()
