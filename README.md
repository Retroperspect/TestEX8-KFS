# TestEX8-KFS
> By Kristian Flejsborg Sørensen (cph-kf96)

## Assignment SPIKE: Technical proof of concept work
details of the assignment can be found [here](https://github.com/datsoftlyngby/soft2018spring-test-teaching-material/blob/master/slides/Cucumber.pdf)

## Cucumber/Gherkin and BDD (Behaviour Driven Development)
The main topic is the problem between programmers and none programmers communication, given the business people can have a hard time formulating excatly what they want from the programmers, and the features can be lost in the translation of those requirements. Through the use of Gherkin structure to make Behaviour driven development syntax, the none programmers can communicate in a way that's familiar to them, which also is clear in it's requirements to the programmer, that with cucumber can implement the very requirement into a testing environment with very little overheader.   
However these method can also work between programmers, as a way to communicate mockable features and code, this allows programmers to program parts of the project without the essential parts being present at the time.

## Pairwise (TestPairs)
TestPair import data can be found [here](https://github.com/Retroperspect/TestEX8-KFS/blob/master/Triangle%20Tests.xml)   
TestPair Export data can be found [here](https://github.com/Retroperspect/TestEX8-KFS/blob/master/Triangle%20Tests_Tests_Threewise.csv)   
Doing testing it was found that using pairwise test data would result in very bad examples, as all examples would result in possible triangles and wouldn't showcase any combinations that would have errors, so using Threewise data set was needed to get a better overview.

## Jmeter/Profilers
Profilers uses different ways to calculate how the code uses the physical mechine it runs on, with this it's possible to find bottlenecks in different part of a system either software or hardware, problem is applying open source profilers which have specific calculations that are broad based and can miss niche problems in your software, to avoid this it's best to implement homebrew profilers though timewise is in question when going this path.   
Personally I had great deal of trouble with Jmeter either with Intellij or Netbeans, using existing structures and looking up resources, as open source profilers seems rather niche in their use, given their status as jack of all trade master of none freeware.   
![](https://i.gyazo.com/d50c2a831eecc5f0cd5b25d2fd4163ce.png)   
