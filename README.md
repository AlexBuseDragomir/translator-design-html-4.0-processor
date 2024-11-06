The goal of this project is to validate an input document and to determine his internal structure.

Each project involves three main phases : scanning, parsing and processing. Additionally, an analyzer for URL or URI strings must be implemented.

Processors can be written in C/C++ or Java.

    Scanning

    One lexical analyser for the proposed language has to be constructed. The parser must detect the tokens of the language and report some lexical errors.
    Parsing

    A parser for the proposed language has to be constructed. The parser has two main goals:
        to validate the input document, and and
        to generate the syntax tree representing the internal structure of the input document; to construct this tree, some actions must to be added to the parser.

    Processing

    This phase uses the syntax tree generated by the parser to show the structure of the input document.

Write a processor for a subset of HTML 4.0 documents with body, containing the following elements:

    body
    frames (frameset, frame, noframe)
    forms (form, input, select, option)
    tables (table, tr, td, th, thead, tbody)
    images (img)
    anchors (a, link)
    lists (ul, ol, li)
    style (b, i, u, small, sup, sub, center, font)
    titles (h1, ..., h6)
    sections (p, hr, br)

The formal definitions of the HTML elements written in SGML can be viewed as grammar rules. The processor must validate an input HTML document and determine its internal structure according to DOM model (Document Object Model for XML/HTML Documents). The structure of a document is a tree having the document as the root node.

In addition, the processor must verify the syntax for contained URLs.