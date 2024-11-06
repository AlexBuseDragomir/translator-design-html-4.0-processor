# HTML 4.0 Processor

The goal of this project is to validate an input document and determine its internal structure.

Each project involves three main phases: scanning, parsing, and processing. Additionally, an analyzer for URL or URI strings must be implemented.

Processors can be written in C/C++ or Java.

## Scanning

A lexical analyzer for the proposed language has to be constructed. The parser must detect the tokens of the language and report any lexical errors.

## Parsing

A parser for the proposed language has to be constructed. The parser has two main goals:

*   To validate the input document.
*   To generate the syntax tree representing the internal structure of the input document; to construct this tree, some actions must be added to the parser.

## Processing

This phase uses the syntax tree generated by the parser to show the structure of the input document.

## Supported HTML Elements

Write a processor for a subset of HTML 4.0 documents with a body, containing the following elements:

*   `body`
*   Frames (`frameset`, `frame`, `noframe`)
*   Forms (`form`, `input`, `select`, `option`)
*   Tables (`table`, `tr`, `td`, `th`, `thead`, `tbody`)
*   Images (`img`)
*   Anchors (`a`, `link`)
*   Lists (`ul`, `ol`, `li`)
*   Style (`b`, `i`, `u`, `small`, `sup`, `sub`, `center`, `font`)
*   Titles (`h1`, ..., `h6`)
*   Sections (`p`, `hr`, `br`)

## Validation and Structure

The formal definitions of the HTML elements written in SGML can be viewed as grammar rules. The processor must validate an input HTML document and determine its internal structure according to the DOM model (Document Object Model for XML/HTML Documents). The structure of a document is a tree with the document as the root node.

In addition, the processor must verify the syntax for contained URLs.

## Disclaimer

All photos used in this project are for **educational purposes only**.  
I do not own any of the photos used.  
Not to be used for commercial purposes.
