package basics;

/**
 * http://en.wikipedia.org/wiki/External_sorting
 * 
 * One example:
 * One example of external sorting is the external merge sort algorithm,
 * which sorts chunks that each fit in RAM, then merges the sorted chunks
 * together.[1][2] For example, for sorting 900 megabytes of data using only 100 megabytes of RAM:

  1.  Read 100 MB of the data in main memory and sort by some conventional method, like quicksort.
  2.  Write the sorted data to disk.
  3. Repeat steps 1 and 2 until all of the data is in sorted 100 MB chunks
   (there are 900MB / 100MB = 9 chunks), which now need to be merged into one single output file.
  4. Read the first 10 MB (= 100MB / (9 chunks + 1)) of each sorted chunk into input buffers
    in main memory and allocate the remaining 10 MB for an output buffer. (In practice,
    it might provide better performance to make the output buffer larger and the input
    buffers slightly smaller.)
   5. Perform a 9-way merge and store the result in the output buffer. Whenever the output
   buffer fills, write it to the final sorted file and empty it. Whenever any of the 9 input
   buffers empties, fill it with the next 10 MB of its associated 100 MB sorted chunk until
   no more data from the chunk is available. This is the key step that makes external merge
   sort work externally -- because the merge algorithm only makes one pass sequentially
   through each of the chunks, each chunk does not have to be loaded completely; rather,
   sequential parts of the chunk can be loaded as needed.
 * 
 * 
 * Here are some tradeoffs in the groups of merging:
 * there is a trade-off with using fewer merge passes. As the number of chunks
 * increases, the amount of data we can read from each chunk at a time during
 * the merge process decreases. For sorting, say, 50 GB in 100 MB of RAM, using
 * a single merge pass isn't efficient: the disk seeks required to fill the input
 * buffers with data from each of the 500 chunks (we read 100MB / 501 ~ 200KB from
 * each chunk at a time) take up most of the sort time. Using two merge passes solves
 * the problem. Then the sorting process might look like this:
   - Run the initial chunk-sorting pass as before.
   - Run a first merge pass combining 25 chunks at a time, resulting in 20 larger sorted chunks.
   -Run a second merge pass to merge the 20 larger sorted chunks.
 * 
 * */
public class ExternalSortDetails {

}
