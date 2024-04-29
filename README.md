# Data_Structures-and-Alogrithms
This repository includes a Java implementation for emulating client and server communication in a star network architecture, as well as a utility class for message compression.

Files Included
-
- ClientNode.java: Represents a node in the star network capable of sending and receiving messages.
- ServerNode.java: Represents the central server node responsible for managing client nodes and message routing
- Star.java: Models the network topology and provides methods for inserting and deleting nodes.
- NetworkSimulation.java: Contains main class for running the network simulation. Provides a command-line interface for interacting with the network.
- CompressionUtil.java: Utilty class for compressing and decompressing messages using the Deflate compression algorithm.

Usage
-
Compile all Java files and execute the 'NetworkSimulation' class to run the simulation. Follow the on-screen instructions to interact with the network.

Commands
-
- register [id]: Registers a new client node with the provided ID.
- unregister [id]: Unregusters an existing client node with the provided ID.
- send [fromId] [toId] [message]: Sends a message from one client node to another.
- broadcast [message]: Sends a message from the server node to all connected client nodes.
- list: Lists all currently connected client nodes.
- exit: Exits the network simulation

Message Compression
-
The 'CompressionUtil' class provides methods for compressing and decompressing messages using the Deflate compression algorithm. This algorithm is chosen for it's balance between compression speed and efficiency. making it suitable for real-time data transmission in network communications.
Deflate is a lossless data compression algorithm that uses a combination of the LZ77 algorithm and Huffman coding. LZ77 identifies repeated sequences in the input data and huffman encodes the output data of LZ77.

To use message compression:
- Call CompressionUtil.compres() to compress a message before sending.
- Call CompressionUtil.decompress() to decompress a received message before processing.

Conclusion
-
This network simulation provides a straightforward but efficient method for engaging with a star network topology. The presented classes and functions make it convenient to manage client nodes and route messages, while message compression optimizes network traffic utilization.

Authors
-
This program was constructed and compiled by Elliot Andrews(220033323) and Aidan Reid(221013539)
