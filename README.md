# multichain-blocktime-sim

A quick hack I once wrote to play around with different block times for a multichain.
It's based on the idea that every time a block of a bridged (or child) chain is mined, a block
in the bridging chain has to be mined as well, containing the block headers of the child chain block.

# Build & run

```bash
mvn clean package exec:java
.
.
.
time=10 blockcollider.height=1 (average=10.0) btc.height=0 eth.height=0 lsk.height=1 neo.height=0 
time=14 blockcollider.height=2 (average=7.0) btc.height=0 eth.height=1 lsk.height=1 neo.height=0 
time=20 blockcollider.height=3 (average=6.6666665) btc.height=0 eth.height=1 lsk.height=2 neo.height=0 
time=28 blockcollider.height=4 (average=7.0) btc.height=0 eth.height=2 lsk.height=2 neo.height=0 
time=30 blockcollider.height=5 (average=6.0) btc.height=0 eth.height=2 lsk.height=3 neo.height=0 
time=40 blockcollider.height=6 (average=6.6666665) btc.height=0 eth.height=2 lsk.height=4 neo.height=0 
time=42 blockcollider.height=7 (average=6.0) btc.height=0 eth.height=3 lsk.height=4 neo.height=0 
time=50 blockcollider.height=8 (average=6.25) btc.height=0 eth.height=3 lsk.height=5 neo.height=0 
.
.
.
The average block time for the base chain is 5.269079 seconds (after 4964400 seconds)
```
