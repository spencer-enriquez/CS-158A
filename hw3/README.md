# Homework 3: Network Forwarding (IP Prefix / NetMask Practice)

NetFwd is supposed to take in a file at the command line call that has the following format:

IPV4 Network Address, NetMask, Port#

After reading the file, Port objects are created for each tuple and the user is prompted to enter an IPv4 address.
By using th XOR operation on the user input, the result is compared to each Port object's address. If it matches with any
Port address, then the respective port number is returned to the user. If not, "Default" is returned to the user.
