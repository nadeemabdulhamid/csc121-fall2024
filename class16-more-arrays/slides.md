---
marp: true
theme: gaia
class: invert
paginate: false



---
# Lecture 16 - More Arrays
CSC 121 - Object Oriented Program Design
Nadeem Abdul Hamid - Fall 2024

<!-- paginate: skip -->
<!-- _class: lead -->



---
## Objectives
<style scoped>ul  { font-size: 90%; line-height: 100%; }</style>

At the end of this lecture you should
- KNOW:
    - "Partial arrays"
    - "Parallel arrays"
    - Arrays of objects
    - For loops

- BE ABLE TO:
    - Write code to process and update parallel arrays and arrays of objects
    - Implement and test different realizations of a data type specified by an interface

<!-- paginate: true -->
<!-- footer: 16 - More Arrays -->


---

```
/**
 * Records hourly temperatures in sequential order, i.e.
 * you cannot record a temperature for hour h until readings for
 * hours 0...(h-1) have been recorded.
 
 * If hours 0...(h-1) have been recorded, you can *rerecord* a temperature
 * for any hour h' < h.
 * 
 */
public class SeqDailyRecord implements IDailyRecord {

	private int[] readings;
	private int count;  // number of actually filled in values
						// in `this.readings`
```