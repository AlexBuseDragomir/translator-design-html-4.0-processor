import java_cup.runtime.*;

%%


%class Html4Lexer
%line
%column
%cup


%{
    StringBuffer string = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }


    public String toString() {
          return ("line : " + (this.yyline + 1) + ", column : " +
						this.yycolumn + ", value :" + this.yytext());
   }

%}


LineTerminator = \r|\n|\r\n

WhiteSpace = {LineTerminator} | [ \t\f]

Identificator = [A-Za-z][A-Za-z_0-9]*

Attribute = [ \t\f] + {Identificator} [ \t]* = [ \t]* \" .* \" [ \t\f\n\r]*
Text = [^<>\n]*


%%

[ \t\f\n\r]* \< html \>                            { return symbol(sym.HTML, yytext().trim()); }

[ \t\f\n\r]* \< \/ html \>                         { return symbol(sym.EHTML, yytext().trim()); }

[ \t\f\n\r]* \< head \>                            { return symbol(sym.HEAD, yytext().trim()); }

[ \t\f\n\r]* \< \/ head \>                         { return symbol(sym.EHEAD, yytext().trim()); }

[ \t\f\n\r]* \< title \>                           { return symbol(sym.TITLE, yytext().trim()); }

[ \t\f\n\r]* \< \/ title \>                        { return symbol(sym.ETITLE, yytext().trim()); }

[ \t\f\n\r]* \< link {Attribute}* \>               { return symbol(sym.LINK, yytext().trim()); }

[ \t\f\n\r]* \< body {Attribute}* \>               { return symbol(sym.BODY, yytext().trim()); }

[ \t\f\n\r]* \< \/ body \>                         { return symbol(sym.EBODY, yytext().trim()); }

[ \t\f\n\r]* \< frameset {Attribute}* \>           { return symbol(sym.FRAMESET, yytext().trim()); }

[ \t\f\n\r]* \< \/ frameset \>                     { return symbol(sym.EFRAMESET, yytext().trim()); }

[ \t\f\n\r]* \< frame {Attribute}* \>              { return symbol(sym.FRAME, yytext().trim()); }

[ \t\f\n\r]* \< noframes \>                        { return symbol(sym.NOFRAMES, yytext().trim()); }

[ \t\f\n\r]* \< \/ noframes \>                     { return symbol(sym.ENOFRAMES, yytext().trim()); }

[ \t\f\n\r]* \< form {Attribute}* \>               { return symbol(sym.FORM, yytext().trim()); }

[ \t\f\n\r]* \< \/ form \>                         { return symbol(sym.EFORM, yytext().trim()); }

[ \t\f\n\r]* \< input {Attribute}* \>              { return symbol(sym.INPUT, yytext().trim()); }

[ \t\f\n\r]* \< select {Attribute}* \>             { return symbol(sym.SELECT, yytext().trim()); }

[ \t\f\n\r]* \< \/ select \>                       { return symbol(sym.ESELECT, yytext().trim()); }

[ \t\f\n\r]* \< option {Attribute}* \>             { return symbol(sym.OPTION, yytext().trim()); }

[ \t\f\n\r]* \< \/ option \>                       { return symbol(sym.EOPTION, yytext().trim()); }

[ \t\f\n\r]* \< table {Attribute}* \>              { return symbol(sym.TABLE, yytext().trim()); }

[ \t\f\n\r]* \< \/ table \>                        { return symbol(sym.ETABLE, yytext().trim()); }

[ \t\f\n\r]* \< tr {Attribute}* \>                 { return symbol(sym.TR, yytext().trim()); }

[ \t\f\n\r]* \< \/ tr \>                           { return symbol(sym.ETR, yytext().trim()); }

[ \t\f\n\r]* \< th {Attribute}* \>                 { return symbol(sym.TH, yytext().trim()); }

[ \t\f\n\r]* \< \/ th \>                           { return symbol(sym.ETH, yytext().trim()); }

[ \t\f\n\r]* \< td {Attribute}* \>                 { return symbol(sym.TD, yytext().trim()); }
 
[ \t\f\n\r]* \< \/ td \>                           { return symbol(sym.ETD, yytext().trim()); }

[ \t\f\n\r]* \< thead \>                           { return symbol(sym.THEAD, yytext().trim()); }

[ \t\f\n\r]* \< \/ thead \>                          { return symbol(sym.ETHEAD, yytext().trim()); }

[ \t\f\n\r]* \< tbody \>                           { return symbol(sym.TBODY, yytext().trim()); }

[ \t\f\n\r]* \< \/ tbody \>                          { return symbol(sym.ETBODY, yytext().trim()); }

[ \t\f\n\r]* \< tfoot \>                           { return symbol(sym.TFOOT, yytext().trim()); }

[ \t\f\n\r]* \< \/ tfoot \>                          { return symbol(sym.ETFOOT, yytext().trim()); }

[ \t\f\n\r]* \< img {Attribute}* \>                { return symbol(sym.IMG, yytext().trim()); }

[ \t\f\n\r]* \< a {Attribute}* \>                  { return symbol(sym.A, yytext().trim()); }

[ \t\f\n\r]* \< \/ a \>                            { return symbol(sym.EA, yytext().trim()); }

[ \t\f\n\r]* \< ul {Attribute}* \>                 { return symbol(sym.UL, yytext().trim()); }

[ \t\f\n\r]* \< \/ ul \>                           { return symbol(sym.EUL, yytext().trim()); }

[ \t\f\n\r]* \< ol {Attribute}* \>                 { return symbol(sym.OL, yytext().trim()); }

[ \t\f\n\r]* \< \/ ol \>                           { return symbol(sym.EOL, yytext().trim()); }
                                                  
[ \t\f\n\r]* \< li \>                              { return symbol(sym.LI, yytext().trim()); }
                                                  
[ \t\f\n\r]* \< \/ li \>                           { return symbol(sym.ELI, yytext().trim()); }
                                                  
[ \t\f\n\r]* \< b \>                               { return symbol(sym.B, yytext().trim()); }
                                                  
[ \t\f\n\r]* \< \/ b \>                            { return symbol(sym.EB, yytext().trim()); }
                                                  
[ \t\f\n\r]* \< i \>                               { return symbol(sym.I, yytext().trim()); }
                                                   
[ \t\f\n\r]* \< \/ i \>                            { return symbol(sym.EI, yytext().trim()); }
                                                  
[ \t\f\n\r]* \< u \>                               { return symbol(sym.U, yytext().trim()); }
                                                  
[ \t\f\n\r]* \< \/ u \>                            { return symbol(sym.EU, yytext().trim()); }

[ \t\f\n\r]* \< small \>                           { return symbol(sym.SMALL, yytext().trim()); }

[ \t\f\n\r]* \< \/ small \>                        { return symbol(sym.ESMALL, yytext().trim()); }

[ \t\f\n\r]* \< sub \>                             { return symbol(sym.SUB, yytext().trim()); }

[ \t\f\n\r]* \< \/ sub \>                          { return symbol(sym.ESUB, yytext().trim()); }

[ \t\f\n\r]* \< sup \>                             { return symbol(sym.SUP, yytext().trim()); }

[ \t\f\n\r]* \< \/ sup \>                          { return symbol(sym.ESUP, yytext().trim()); }

[ \t\f\n\r]* \< font {Attribute}* \>               { return symbol(sym.FONT, yytext().trim()); }

[ \t\f\n\r]* \< \/ font \>                         { return symbol(sym.EFONT, yytext().trim()); }

[ \t\f\n\r]* \< center \>                          { return symbol(sym.CENTER, yytext().trim()); }

[ \t\f\n\r]* \< \/ center \>                       { return symbol(sym.ECENTER, yytext().trim()); }

[ \t\f\n\r]* \< h1 {Attribute}* \>                 { return symbol(sym.H1, yytext().trim()); }

[ \t\f\n\r]* \< \/ h1 \>                           { return symbol(sym.EH1, yytext().trim()); }

[ \t\f\n\r]* \< h2 {Attribute}* \>                 { return symbol(sym.H2, yytext().trim()); }

[ \t\f\n\r]* \< \/ h2 \>                           { return symbol(sym.EH2, yytext().trim()); }

[ \t\f\n\r]* \< h3 {Attribute}* \>                 { return symbol(sym.H3, yytext().trim()); }

[ \t\f\n\r]* \< \/ h3 \>                           { return symbol(sym.EH3, yytext().trim()); }

[ \t\f\n\r]* \< h4 {Attribute}* \>                 { return symbol(sym.H4, yytext().trim()); }

[ \t\f\n\r]* \< \/ h4 \>                           { return symbol(sym.EH4, yytext().trim()); }

[ \t\f\n\r]* \< h5 {Attribute}* \>                 { return symbol(sym.H5, yytext().trim()); }

[ \t\f\n\r]* \< \/ h5 \>                           { return symbol(sym.EH5, yytext().trim()); }

[ \t\f\n\r]* \< h6 {Attribute}* \>                 { return symbol(sym.H6, yytext().trim()); }

[ \t\f\n\r]* \< \/ h6 \>                           { return symbol(sym.EH6, yytext().trim()); }

[ \t\f\n\r]* \< p \>                               { return symbol(sym.P, yytext().trim()); }

[ \t\f\n\r]* \< \/ p \>                            { return symbol(sym.EP, yytext().trim()); }

[ \t\f\n\r]* \< hr {Attribute}* \>                 { return symbol(sym.HR, yytext().trim()); }

[ \t\f\n\r]* \< br \>                              { return symbol(sym.BR, yytext().trim()); }


{WhiteSpace}       {  /* just skip what was found, do nothing */ }

{Text}                 {return symbol(sym.TEXT, yytext().trim());}

[^]                    { throw new Error("Illegal character <"+yytext()+">"); }