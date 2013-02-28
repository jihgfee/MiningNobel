/**********************************************************************
 *  Programming assignment: Mining for Nobel
 **********************************************************************/

Name1: Jonas Kastberg
Email1: jkas@itu.dk
Name2: Martin Juul Petersen
Email2: mjup@itu.dk
Group name: FOURSOOOOOMEEE!!!

Operating system: Windows 7
Text editor / IDE: notepad++

Optional: Total hours to complete assignment: 4 hours


Please mark one of the following boxes with an X

[ x ] Yes, to the best of our knowledge, our N^3 log N solution works as
it should.

[ ] No, our solution does not work. (We will not get credit for this.)
Here's what doesn't work:



/**********************************************************************
 * Consider your exhaustive search implementation.
 *
 * Let N denote the number of input values.
 *
 * Estimate the number of comparisons by looking at the code. 
 * Use tilde notation.
 * (Don't forget  the comparisons in the condition of your for loops!)
 * 
 * Perform experimental running time analysis using the Stopwatch
 * class from Sedgewick and Wayne, Algorithms 4th edition.
 *
 * Estimate the largest N you can process based on your theoretical
 * and practical analyses.
 **********************************************************************/

Number of comparisons performed as a function of N:  ~2N^4

Experiments:

 N          time (seconds)
------------------------------
200			03.824
250			09.245
300			19.086
353			36.391

[ X ] Yes, our experiments are consistent with our theoretical analysis

[ ] No, they are not. Instead, it looks more as if ....

Largest values of N in given time limit
---------------------------------------
1 minute: 395
1 day:    2474
1 year:   10951 

/**********************************************************************
 * Results
 **********************************************************************/

Number of 4-tuples in constants.csv that sum to 0 found by 
our exhaustive search implementation:    528
our N^3 log N implementation:            528
(optional) our N^2 log N implementation: 528

/**********************************************************************
 * More numbers!
 *
 * This part is completely optional. Please help making this exercise
 * better by providing even more important-looking constants.
 * Remember that we need the natural logarithm, rounded to the nearest
 * power of 2^(-20). Do it like this:
 *
 *   private static final double rounding = 9.5367431640625E-7;
 *
 *   private static  double round(double value) {
 *	  return ((int) (value / rounding)) * rounding;
 *      }
 *   ...
 *   double ln_value = round(Math.log( the_original_value ))); 
 *   ...
 *
 * Use the format below, with the original value in parentheses.
 *
 * If I find your suggestions sufficiently entertaining I'll
 * put them in the next version of  this exercise.
 * If you want to be credited, please tell me by which name
 * here: .......
 ******************************************************************/

international telephone dial code for Antarctica (672) , 6.510257720947266
... , ...



/**********************************************************************
 *  List whatever help (if any) that you received, including help
 *  from TAs or fellow students. (Such help is allowed, but we want
 *  you to acknowledge it.)
 **********************************************************************/

 We worked together with Michael Frikke when doing the experimental running time analysis,
 in order to save time, since the running times tend to be huge.
 
 We received some help from Jakob Merrild with the reading of the file.
 We had a hard time figuring the correct way to use the StdIn.

/**********************************************************************
 *  List any other comments here. Feel free to provide any feedback   
 *  on how much you learned from doing the assignment, and whether    
 *  you enjoyed doing it. In particular, tell us how this exercise 
 *  could be improved.                                             
 **********************************************************************/
 
 Awesome assignment - very nice with a comical sidedish to the everyday algorithm excercise