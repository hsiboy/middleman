// $ANTLR 3.3 Nov 30, 2010 12:50:56 /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g 2014-11-04 23:41:06

package middleman.configuration;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ConfigurationLexer extends Lexer {
    public static final int EOF=-1;
    public static final int PORT=4;
    public static final int EQ=5;
    public static final int NUMBER=6;
    public static final int PROXY=7;
    public static final int IDENTIFIER=8;
    public static final int BEGIN=9;
    public static final int END=10;
    public static final int OUTPROXY=11;
    public static final int STRING=12;
    public static final int DEBUG=13;
    public static final int STUB=14;
    public static final int HOSTNAME=15;
    public static final int STATUSCODE=16;
    public static final int HEADER=17;
    public static final int BLOCK=18;
    public static final int BODY=19;
    public static final int OPENBLOCK=20;
    public static final int CLOSEBLOCK=21;
    public static final int DIGIT=22;
    public static final int LETTER=23;
    public static final int WORD=24;
    public static final int SEPERATOR=25;
    public static final int DNSCHAR=26;
    public static final int URL=27;
    public static final int NEWLINE=28;
    public static final int WS=29;
    public static final int COMMENT=30;
    public static final int LINE_COMMENT=31;

    // delegates
    // delegators

    public ConfigurationLexer() {;} 
    public ConfigurationLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public ConfigurationLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "/Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g"; }

    // $ANTLR start "PROXY"
    public final void mPROXY() throws RecognitionException {
        try {
            int _type = PROXY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:47:10: ( 'proxy' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:47:12: 'proxy'
            {
            match("proxy"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PROXY"

    // $ANTLR start "BEGIN"
    public final void mBEGIN() throws RecognitionException {
        try {
            int _type = BEGIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:48:10: ( '{' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:48:12: '{'
            {
            match('{'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BEGIN"

    // $ANTLR start "END"
    public final void mEND() throws RecognitionException {
        try {
            int _type = END;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:49:12: ( '}' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:49:14: '}'
            {
            match('}'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "END"

    // $ANTLR start "STUB"
    public final void mSTUB() throws RecognitionException {
        try {
            int _type = STUB;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:50:9: ( 'stub' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:50:11: 'stub'
            {
            match("stub"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STUB"

    // $ANTLR start "PORT"
    public final void mPORT() throws RecognitionException {
        try {
            int _type = PORT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:51:9: ( 'port' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:51:11: 'port'
            {
            match("port"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PORT"

    // $ANTLR start "STATUSCODE"
    public final void mSTATUSCODE() throws RecognitionException {
        try {
            int _type = STATUSCODE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:52:12: ( 'status-code' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:52:14: 'status-code'
            {
            match("status-code"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STATUSCODE"

    // $ANTLR start "HEADER"
    public final void mHEADER() throws RecognitionException {
        try {
            int _type = HEADER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:53:11: ( 'header' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:53:13: 'header'
            {
            match("header"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HEADER"

    // $ANTLR start "BODY"
    public final void mBODY() throws RecognitionException {
        try {
            int _type = BODY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:54:9: ( 'body' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:54:11: 'body'
            {
            match("body"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BODY"

    // $ANTLR start "OUTPROXY"
    public final void mOUTPROXY() throws RecognitionException {
        try {
            int _type = OUTPROXY;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:55:12: ( 'outgoing-proxy' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:55:14: 'outgoing-proxy'
            {
            match("outgoing-proxy"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OUTPROXY"

    // $ANTLR start "DEBUG"
    public final void mDEBUG() throws RecognitionException {
        try {
            int _type = DEBUG;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:56:10: ( 'debug' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:56:12: 'debug'
            {
            match("debug"); if (state.failed) return ;


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "DEBUG"

    // $ANTLR start "OPENBLOCK"
    public final void mOPENBLOCK() throws RecognitionException {
        try {
            int _type = OPENBLOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:57:11: ( '[' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:57:13: '['
            {
            match('['); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "OPENBLOCK"

    // $ANTLR start "CLOSEBLOCK"
    public final void mCLOSEBLOCK() throws RecognitionException {
        try {
            int _type = CLOSEBLOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:58:12: ( ']' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:58:15: ']'
            {
            match(']'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "CLOSEBLOCK"

    // $ANTLR start "EQ"
    public final void mEQ() throws RecognitionException {
        try {
            int _type = EQ;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:59:4: ( '=' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:59:6: '='
            {
            match('='); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EQ"

    // $ANTLR start "DIGIT"
    public final void mDIGIT() throws RecognitionException {
        try {
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:61:17: ( '0' .. '9' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:61:19: '0' .. '9'
            {
            matchRange('0','9'); if (state.failed) return ;

            }

        }
        finally {
        }
    }
    // $ANTLR end "DIGIT"

    // $ANTLR start "LETTER"
    public final void mLETTER() throws RecognitionException {
        try {
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:63:17: ( 'a' .. 'z' | 'A' .. 'Z' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:
            {
            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "LETTER"

    // $ANTLR start "NUMBER"
    public final void mNUMBER() throws RecognitionException {
        try {
            int _type = NUMBER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:65:8: ( ( DIGIT )+ )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:65:10: ( DIGIT )+
            {
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:65:10: ( DIGIT )+
            int cnt1=0;
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>='0' && LA1_0<='9')) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:65:10: DIGIT
            	    {
            	    mDIGIT(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt1 >= 1 ) break loop1;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(1, input);
                        throw eee;
                }
                cnt1++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NUMBER"

    // $ANTLR start "WORD"
    public final void mWORD() throws RecognitionException {
        try {
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:67:15: ( ( LETTER )+ )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:67:17: ( LETTER )+
            {
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:67:17: ( LETTER )+
            int cnt2=0;
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='A' && LA2_0<='Z')||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:67:17: LETTER
            	    {
            	    mLETTER(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt2 >= 1 ) break loop2;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(2, input);
                        throw eee;
                }
                cnt2++;
            } while (true);


            }

        }
        finally {
        }
    }
    // $ANTLR end "WORD"

    // $ANTLR start "SEPERATOR"
    public final void mSEPERATOR() throws RecognitionException {
        try {
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:69:20: ( '-' | '_' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:
            {
            if ( input.LA(1)=='-'||input.LA(1)=='_' ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "SEPERATOR"

    // $ANTLR start "DNSCHAR"
    public final void mDNSCHAR() throws RecognitionException {
        try {
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:72:18: ( LETTER | DIGIT | '-' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:
            {
            if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}


            }

        }
        finally {
        }
    }
    // $ANTLR end "DNSCHAR"

    // $ANTLR start "IDENTIFIER"
    public final void mIDENTIFIER() throws RecognitionException {
        try {
            int _type = IDENTIFIER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:74:13: ( ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' ) ( '_' | '-' | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )* )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:74:15: ( '0' .. '9' | 'a' .. 'z' | 'A' .. 'Z' | '_' | '-' ) ( '_' | '-' | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            {
            if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();
            state.failed=false;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:74:55: ( '_' | '-' | 'a' .. 'z' | 'A' .. 'Z' | '0' .. '9' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0=='-'||(LA3_0>='0' && LA3_0<='9')||(LA3_0>='A' && LA3_0<='Z')||LA3_0=='_'||(LA3_0>='a' && LA3_0<='z')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:
            	    {
            	    if ( input.LA(1)=='-'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "IDENTIFIER"

    // $ANTLR start "STRING"
    public final void mSTRING() throws RecognitionException {
        try {
            int _type = STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:76:8: ( '\"' ( '\\\\' . | ~ ( '\\\\' | '\"' ) )* '\"' )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:76:10: '\"' ( '\\\\' . | ~ ( '\\\\' | '\"' ) )* '\"'
            {
            match('\"'); if (state.failed) return ;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:76:14: ( '\\\\' . | ~ ( '\\\\' | '\"' ) )*
            loop4:
            do {
                int alt4=3;
                int LA4_0 = input.LA(1);

                if ( (LA4_0=='\\') ) {
                    alt4=1;
                }
                else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                    alt4=2;
                }


                switch (alt4) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:76:16: '\\\\' .
            	    {
            	    match('\\'); if (state.failed) return ;
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:76:25: ~ ( '\\\\' | '\"' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            match('\"'); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "STRING"

    // $ANTLR start "URL"
    public final void mURL() throws RecognitionException {
        try {
            int _type = URL;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:78:5: ( 'http://' ( DNSCHAR | '\\.' | ':' | '/' )+ )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:78:7: 'http://' ( DNSCHAR | '\\.' | ':' | '/' )+
            {
            match("http://"); if (state.failed) return ;

            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:78:17: ( DNSCHAR | '\\.' | ':' | '/' )+
            int cnt5=0;
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>='-' && LA5_0<=':')||(LA5_0>='A' && LA5_0<='Z')||(LA5_0>='a' && LA5_0<='z')) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:
            	    {
            	    if ( (input.LA(1)>='-' && input.LA(1)<=':')||(input.LA(1)>='A' && input.LA(1)<='Z')||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt5 >= 1 ) break loop5;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(5, input);
                        throw eee;
                }
                cnt5++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "URL"

    // $ANTLR start "HOSTNAME"
    public final void mHOSTNAME() throws RecognitionException {
        try {
            int _type = HOSTNAME;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:9: ( ( NUMBER | WORD ) ( NUMBER | WORD | '-' | '_' )* ( '.' ( ( NUMBER | WORD ) ( NUMBER | WORD | '-' | '_' )* ) )* )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:11: ( NUMBER | WORD ) ( NUMBER | WORD | '-' | '_' )* ( '.' ( ( NUMBER | WORD ) ( NUMBER | WORD | '-' | '_' )* ) )*
            {
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:11: ( NUMBER | WORD )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( ((LA6_0>='0' && LA6_0<='9')) ) {
                alt6=1;
            }
            else if ( ((LA6_0>='A' && LA6_0<='Z')||(LA6_0>='a' && LA6_0<='z')) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:13: NUMBER
                    {
                    mNUMBER(); if (state.failed) return ;

                    }
                    break;
                case 2 :
                    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:22: WORD
                    {
                    mWORD(); if (state.failed) return ;

                    }
                    break;

            }

            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:29: ( NUMBER | WORD | '-' | '_' )*
            loop7:
            do {
                int alt7=5;
                switch ( input.LA(1) ) {
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    {
                    alt7=1;
                    }
                    break;
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                case 'e':
                case 'f':
                case 'g':
                case 'h':
                case 'i':
                case 'j':
                case 'k':
                case 'l':
                case 'm':
                case 'n':
                case 'o':
                case 'p':
                case 'q':
                case 'r':
                case 's':
                case 't':
                case 'u':
                case 'v':
                case 'w':
                case 'x':
                case 'y':
                case 'z':
                    {
                    alt7=2;
                    }
                    break;
                case '-':
                    {
                    alt7=3;
                    }
                    break;
                case '_':
                    {
                    alt7=4;
                    }
                    break;

                }

                switch (alt7) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:31: NUMBER
            	    {
            	    mNUMBER(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:40: WORD
            	    {
            	    mWORD(); if (state.failed) return ;

            	    }
            	    break;
            	case 3 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:47: '-'
            	    {
            	    match('-'); if (state.failed) return ;

            	    }
            	    break;
            	case 4 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:53: '_'
            	    {
            	    match('_'); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:60: ( '.' ( ( NUMBER | WORD ) ( NUMBER | WORD | '-' | '_' )* ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0=='.') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:62: '.' ( ( NUMBER | WORD ) ( NUMBER | WORD | '-' | '_' )* )
            	    {
            	    match('.'); if (state.failed) return ;
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:66: ( ( NUMBER | WORD ) ( NUMBER | WORD | '-' | '_' )* )
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:68: ( NUMBER | WORD ) ( NUMBER | WORD | '-' | '_' )*
            	    {
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:68: ( NUMBER | WORD )
            	    int alt8=2;
            	    int LA8_0 = input.LA(1);

            	    if ( ((LA8_0>='0' && LA8_0<='9')) ) {
            	        alt8=1;
            	    }
            	    else if ( ((LA8_0>='A' && LA8_0<='Z')||(LA8_0>='a' && LA8_0<='z')) ) {
            	        alt8=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 8, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt8) {
            	        case 1 :
            	            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:70: NUMBER
            	            {
            	            mNUMBER(); if (state.failed) return ;

            	            }
            	            break;
            	        case 2 :
            	            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:79: WORD
            	            {
            	            mWORD(); if (state.failed) return ;

            	            }
            	            break;

            	    }

            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:86: ( NUMBER | WORD | '-' | '_' )*
            	    loop9:
            	    do {
            	        int alt9=5;
            	        switch ( input.LA(1) ) {
            	        case '0':
            	        case '1':
            	        case '2':
            	        case '3':
            	        case '4':
            	        case '5':
            	        case '6':
            	        case '7':
            	        case '8':
            	        case '9':
            	            {
            	            alt9=1;
            	            }
            	            break;
            	        case 'A':
            	        case 'B':
            	        case 'C':
            	        case 'D':
            	        case 'E':
            	        case 'F':
            	        case 'G':
            	        case 'H':
            	        case 'I':
            	        case 'J':
            	        case 'K':
            	        case 'L':
            	        case 'M':
            	        case 'N':
            	        case 'O':
            	        case 'P':
            	        case 'Q':
            	        case 'R':
            	        case 'S':
            	        case 'T':
            	        case 'U':
            	        case 'V':
            	        case 'W':
            	        case 'X':
            	        case 'Y':
            	        case 'Z':
            	        case 'a':
            	        case 'b':
            	        case 'c':
            	        case 'd':
            	        case 'e':
            	        case 'f':
            	        case 'g':
            	        case 'h':
            	        case 'i':
            	        case 'j':
            	        case 'k':
            	        case 'l':
            	        case 'm':
            	        case 'n':
            	        case 'o':
            	        case 'p':
            	        case 'q':
            	        case 'r':
            	        case 's':
            	        case 't':
            	        case 'u':
            	        case 'v':
            	        case 'w':
            	        case 'x':
            	        case 'y':
            	        case 'z':
            	            {
            	            alt9=2;
            	            }
            	            break;
            	        case '-':
            	            {
            	            alt9=3;
            	            }
            	            break;
            	        case '_':
            	            {
            	            alt9=4;
            	            }
            	            break;

            	        }

            	        switch (alt9) {
            	    	case 1 :
            	    	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:88: NUMBER
            	    	    {
            	    	    mNUMBER(); if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 2 :
            	    	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:97: WORD
            	    	    {
            	    	    mWORD(); if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 3 :
            	    	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:104: '-'
            	    	    {
            	    	    match('-'); if (state.failed) return ;

            	    	    }
            	    	    break;
            	    	case 4 :
            	    	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:80:110: '_'
            	    	    {
            	    	    match('_'); if (state.failed) return ;

            	    	    }
            	    	    break;

            	    	default :
            	    	    break loop9;
            	        }
            	    } while (true);


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "HOSTNAME"

    // $ANTLR start "BLOCK"
    public final void mBLOCK() throws RecognitionException {
        try {
            int _type = BLOCK;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:83:7: ( OPENBLOCK ( options {backtrack=true; } : BLOCK | ~ CLOSEBLOCK )* CLOSEBLOCK )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:83:9: OPENBLOCK ( options {backtrack=true; } : BLOCK | ~ CLOSEBLOCK )* CLOSEBLOCK
            {
            mOPENBLOCK(); if (state.failed) return ;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:83:19: ( options {backtrack=true; } : BLOCK | ~ CLOSEBLOCK )*
            loop11:
            do {
                int alt11=3;
                int LA11_0 = input.LA(1);

                if ( (LA11_0=='[') ) {
                    int LA11_2 = input.LA(2);

                    if ( (synpred1_Configuration()) ) {
                        alt11=1;
                    }
                    else if ( (synpred2_Configuration()) ) {
                        alt11=2;
                    }


                }
                else if ( ((LA11_0>='\u0000' && LA11_0<='Z')||LA11_0=='\\'||(LA11_0>='^' && LA11_0<='\uFFFF')) ) {
                    alt11=2;
                }


                switch (alt11) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:83:48: BLOCK
            	    {
            	    mBLOCK(); if (state.failed) return ;

            	    }
            	    break;
            	case 2 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:83:56: ~ CLOSEBLOCK
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\u0014')||(input.LA(1)>='\u0016' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            mCLOSEBLOCK(); if (state.failed) return ;

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "BLOCK"

    // $ANTLR start "NEWLINE"
    public final void mNEWLINE() throws RecognitionException {
        try {
            int _type = NEWLINE;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:87:8: ( ( ( '\\r' )? '\\n' )+ )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:87:10: ( ( '\\r' )? '\\n' )+
            {
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:87:10: ( ( '\\r' )? '\\n' )+
            int cnt13=0;
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0=='\n'||LA13_0=='\r') ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:87:11: ( '\\r' )? '\\n'
            	    {
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:87:11: ( '\\r' )?
            	    int alt12=2;
            	    int LA12_0 = input.LA(1);

            	    if ( (LA12_0=='\r') ) {
            	        alt12=1;
            	    }
            	    switch (alt12) {
            	        case 1 :
            	            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:87:11: '\\r'
            	            {
            	            match('\r'); if (state.failed) return ;

            	            }
            	            break;

            	    }

            	    match('\n'); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    if ( cnt13 >= 1 ) break loop13;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(13, input);
                        throw eee;
                }
                cnt13++;
            } while (true);

            if ( state.backtracking==0 ) {
               skip(); 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "NEWLINE"

    // $ANTLR start "WS"
    public final void mWS() throws RecognitionException {
        try {
            int _type = WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:89:4: ( ( ' ' | '\\u000C' | '\\t' )+ )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:89:6: ( ' ' | '\\u000C' | '\\t' )+
            {
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:89:6: ( ' ' | '\\u000C' | '\\t' )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0=='\t'||LA14_0=='\f'||LA14_0==' ') ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:
            	    {
            	    if ( input.LA(1)=='\t'||input.LA(1)=='\f'||input.LA(1)==' ' ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return ;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            if ( state.backtracking==0 ) {
               skip(); 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "WS"

    // $ANTLR start "COMMENT"
    public final void mCOMMENT() throws RecognitionException {
        try {
            int _type = COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:93:5: ( '/*' ( . )* '*/' ( NEWLINE )? )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:93:7: '/*' ( . )* '*/' ( NEWLINE )?
            {
            match("/*"); if (state.failed) return ;

            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:93:12: ( . )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0=='*') ) {
                    int LA15_1 = input.LA(2);

                    if ( (LA15_1=='/') ) {
                        alt15=2;
                    }
                    else if ( ((LA15_1>='\u0000' && LA15_1<='.')||(LA15_1>='0' && LA15_1<='\uFFFF')) ) {
                        alt15=1;
                    }


                }
                else if ( ((LA15_0>='\u0000' && LA15_0<=')')||(LA15_0>='+' && LA15_0<='\uFFFF')) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:93:12: .
            	    {
            	    matchAny(); if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            match("*/"); if (state.failed) return ;

            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:93:20: ( NEWLINE )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0=='\n'||LA16_0=='\r') ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:93:20: NEWLINE
                    {
                    mNEWLINE(); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
              skip();
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "COMMENT"

    // $ANTLR start "LINE_COMMENT"
    public final void mLINE_COMMENT() throws RecognitionException {
        try {
            int _type = LINE_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:96:13: ( '//' (~ ( '\\r' | '\\n' ) )* NEWLINE )
            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:96:15: '//' (~ ( '\\r' | '\\n' ) )* NEWLINE
            {
            match("//"); if (state.failed) return ;

            // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:96:20: (~ ( '\\r' | '\\n' ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( ((LA17_0>='\u0000' && LA17_0<='\t')||(LA17_0>='\u000B' && LA17_0<='\f')||(LA17_0>='\u000E' && LA17_0<='\uFFFF')) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:96:20: ~ ( '\\r' | '\\n' )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();
            	    state.failed=false;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return ;}
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            mNEWLINE(); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               skip(); 
            }

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LINE_COMMENT"

    public void mTokens() throws RecognitionException {
        // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:8: ( PROXY | BEGIN | END | STUB | PORT | STATUSCODE | HEADER | BODY | OUTPROXY | DEBUG | OPENBLOCK | CLOSEBLOCK | EQ | NUMBER | IDENTIFIER | STRING | URL | HOSTNAME | BLOCK | NEWLINE | WS | COMMENT | LINE_COMMENT )
        int alt18=23;
        alt18 = dfa18.predict(input);
        switch (alt18) {
            case 1 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:10: PROXY
                {
                mPROXY(); if (state.failed) return ;

                }
                break;
            case 2 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:16: BEGIN
                {
                mBEGIN(); if (state.failed) return ;

                }
                break;
            case 3 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:22: END
                {
                mEND(); if (state.failed) return ;

                }
                break;
            case 4 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:26: STUB
                {
                mSTUB(); if (state.failed) return ;

                }
                break;
            case 5 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:31: PORT
                {
                mPORT(); if (state.failed) return ;

                }
                break;
            case 6 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:36: STATUSCODE
                {
                mSTATUSCODE(); if (state.failed) return ;

                }
                break;
            case 7 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:47: HEADER
                {
                mHEADER(); if (state.failed) return ;

                }
                break;
            case 8 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:54: BODY
                {
                mBODY(); if (state.failed) return ;

                }
                break;
            case 9 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:59: OUTPROXY
                {
                mOUTPROXY(); if (state.failed) return ;

                }
                break;
            case 10 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:68: DEBUG
                {
                mDEBUG(); if (state.failed) return ;

                }
                break;
            case 11 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:74: OPENBLOCK
                {
                mOPENBLOCK(); if (state.failed) return ;

                }
                break;
            case 12 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:84: CLOSEBLOCK
                {
                mCLOSEBLOCK(); if (state.failed) return ;

                }
                break;
            case 13 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:95: EQ
                {
                mEQ(); if (state.failed) return ;

                }
                break;
            case 14 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:98: NUMBER
                {
                mNUMBER(); if (state.failed) return ;

                }
                break;
            case 15 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:105: IDENTIFIER
                {
                mIDENTIFIER(); if (state.failed) return ;

                }
                break;
            case 16 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:116: STRING
                {
                mSTRING(); if (state.failed) return ;

                }
                break;
            case 17 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:123: URL
                {
                mURL(); if (state.failed) return ;

                }
                break;
            case 18 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:127: HOSTNAME
                {
                mHOSTNAME(); if (state.failed) return ;

                }
                break;
            case 19 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:136: BLOCK
                {
                mBLOCK(); if (state.failed) return ;

                }
                break;
            case 20 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:142: NEWLINE
                {
                mNEWLINE(); if (state.failed) return ;

                }
                break;
            case 21 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:150: WS
                {
                mWS(); if (state.failed) return ;

                }
                break;
            case 22 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:153: COMMENT
                {
                mCOMMENT(); if (state.failed) return ;

                }
                break;
            case 23 :
                // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:1:161: LINE_COMMENT
                {
                mLINE_COMMENT(); if (state.failed) return ;

                }
                break;

        }

    }

    // $ANTLR start synpred1_Configuration
    public final void synpred1_Configuration_fragment() throws RecognitionException {   
        // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:83:48: ( BLOCK )
        // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:83:48: BLOCK
        {
        mBLOCK(); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred1_Configuration

    // $ANTLR start synpred2_Configuration
    public final void synpred2_Configuration_fragment() throws RecognitionException {   
        // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:83:56: (~ CLOSEBLOCK )
        // /Users/tomtaylor/Documents/workspace/middleman/src/middleman/configuration/Configuration.g:83:56: ~ CLOSEBLOCK
        {
        if ( (input.LA(1)>='\u0000' && input.LA(1)<='\u0014')||(input.LA(1)>='\u0016' && input.LA(1)<='\uFFFF') ) {
            input.consume();
        state.failed=false;
        }
        else {
            if (state.backtracking>0) {state.failed=true; return ;}
            MismatchedSetException mse = new MismatchedSetException(null,input);
            recover(mse);
            throw mse;}


        }
    }
    // $ANTLR end synpred2_Configuration

    public final boolean synpred1_Configuration() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_Configuration_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_Configuration() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_Configuration_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA18_eotS =
        "\1\uffff\1\17\2\uffff\5\17\1\40\2\uffff\1\42\1\17\5\uffff\6\17\1"+
        "\uffff\6\17\3\uffff\1\42\1\17\2\uffff\12\17\1\72\1\73\3\17\1\77"+
        "\2\17\1\102\2\uffff\2\17\2\uffff\1\17\1\106\1\uffff\1\17\1\110\1"+
        "\17\1\uffff\1\17\1\uffff\7\17\1\122\1\17\1\uffff\2\17\1\126\1\uffff";
    static final String DFA18_eofS =
        "\127\uffff";
    static final String DFA18_minS =
        "\1\11\1\55\2\uffff\5\55\1\0\2\uffff\2\55\4\uffff\1\52\6\55\1\uffff"+
        "\6\55\3\uffff\2\55\2\uffff\23\55\2\uffff\2\55\2\uffff\2\55\1\uffff"+
        "\3\55\1\uffff\1\55\1\uffff\11\55\1\uffff\3\55\1\uffff";
    static final String DFA18_maxS =
        "\1\175\1\172\2\uffff\5\172\1\uffff\2\uffff\2\172\4\uffff\1\57\6"+
        "\172\1\uffff\6\172\3\uffff\2\172\2\uffff\23\172\2\uffff\2\172\2"+
        "\uffff\2\172\1\uffff\3\172\1\uffff\1\172\1\uffff\11\172\1\uffff"+
        "\3\172\1\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\1\3\6\uffff\1\14\1\15\2\uffff\1\20\1\17\1\24\1\25\7"+
        "\uffff\1\22\6\uffff\1\13\1\23\1\16\2\uffff\1\26\1\27\23\uffff\1"+
        "\5\1\4\2\uffff\1\21\1\10\2\uffff\1\1\3\uffff\1\12\1\uffff\1\7\11"+
        "\uffff\1\6\3\uffff\1\11";
    static final String DFA18_specialS =
        "\11\uffff\1\0\115\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\21\1\20\1\uffff\1\21\1\20\22\uffff\1\21\1\uffff\1\16\12\uffff"+
            "\1\17\1\uffff\1\22\12\14\3\uffff\1\13\3\uffff\32\15\1\11\1\uffff"+
            "\1\12\1\uffff\1\17\1\uffff\1\15\1\6\1\15\1\10\3\15\1\5\6\15"+
            "\1\7\1\1\2\15\1\4\7\15\1\2\1\uffff\1\3",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\16\26\1\24\2\26\1\23\10\26",
            "",
            "",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\23\26\1\32\6\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\4\26\1\33\16\26\1\34\6\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\16\26\1\35\13\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\24\26\1\36\5\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\4\26\1\37\25\26",
            "\0\41",
            "",
            "",
            "\1\27\1\31\1\uffff\12\43\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\32\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\32\26",
            "",
            "",
            "",
            "",
            "\1\45\4\uffff\1\46",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\16\26\1\47\13\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\21\26\1\50\10\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\32\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\32\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\32\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\32\44",
            "",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\1\52\23\26\1\51\5\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\1\53\31\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\23\26\1\54\6\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\3\26\1\55\26\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\23\26\1\56\6\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\1\26\1\57\30\26",
            "",
            "",
            "",
            "\1\27\1\31\1\uffff\12\43\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\32\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\32\44",
            "",
            "",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\27\26\1\60\2\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\23\26\1\61\6\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\1\26\1\62\30\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\23\26\1\63\6\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\3\26\1\64\26\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\17\26\1\65\12\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\30\26\1\66\1\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\6\26\1\67\23\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\24\26\1\70\5\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\30\26\1\71\1\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\32\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\32\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\24\26\1\74\5\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\4\26\1\75\25\26",
            "\1\27\1\31\1\uffff\12\25\1\76\6\uffff\32\26\4\uffff\1\30\1"+
            "\uffff\32\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\32\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\16\26\1\100\13\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\6\26\1\101\23\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\32\26",
            "",
            "",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\22\26\1\103\7\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\21\26\1\104\10\26",
            "",
            "",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\10\26\1\105\21\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\32\26",
            "",
            "\1\107\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\32\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\32\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\15\26\1\111\14\26",
            "",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\2\44\1\112\27\44",
            "",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\6\26\1\113\23\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\16\44\1\114\13\44",
            "\1\115\1\31\1\uffff\12\25\7\uffff\32\26\4\uffff\1\30\1\uffff"+
            "\32\26",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\3\44\1\116\26\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\17\44\1\117\12\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\4\44\1\120\25\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\21\44\1\121\10\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\32\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\16\44\1\123\13\44",
            "",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\27\44\1\124\2\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\30\44\1\125\1\44",
            "\1\27\1\31\1\uffff\12\25\7\uffff\32\44\4\uffff\1\30\1\uffff"+
            "\32\44",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( PROXY | BEGIN | END | STUB | PORT | STATUSCODE | HEADER | BODY | OUTPROXY | DEBUG | OPENBLOCK | CLOSEBLOCK | EQ | NUMBER | IDENTIFIER | STRING | URL | HOSTNAME | BLOCK | NEWLINE | WS | COMMENT | LINE_COMMENT );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA18_9 = input.LA(1);

                        s = -1;
                        if ( ((LA18_9>='\u0000' && LA18_9<='\uFFFF')) ) {s = 33;}

                        else s = 32;

                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 18, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}