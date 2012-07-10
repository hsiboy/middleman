// $ANTLR 3.3 Nov 30, 2010 12:50:56 c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g 2012-07-10 13:26:30

package middleman.configuration;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
public class ConfigurationParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PORT", "EQ", "NUMBER", "PROXY", "IDENTIFIER", "BEGIN", "END", "OUTPROXY", "STRING", "DEBUG", "STUB", "HOSTNAME", "STATUSCODE", "HEADER", "BLOCK", "BODY", "OPENBLOCK", "CLOSEBLOCK", "DIGIT", "LETTER", "WORD", "SEPERATOR", "DNSCHAR", "URL", "NEWLINE", "WS", "COMMENT", "LINE_COMMENT"
    };
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


        public ConfigurationParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public ConfigurationParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return ConfigurationParser.tokenNames; }
    public String getGrammarFileName() { return "c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g"; }



    // $ANTLR start "configuration"
    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:11:1: configuration[MiddlemanConfiguration config] : ( configurationStatement[config] )* EOF ;
    public final void configuration(MiddlemanConfiguration config) throws RecognitionException {
        try {
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:12:2: ( ( configurationStatement[config] )* EOF )
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:12:4: ( configurationStatement[config] )* EOF
            {
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:12:4: ( configurationStatement[config] )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==PORT||LA1_0==PROXY) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:12:5: configurationStatement[config]
            	    {
            	    pushFollow(FOLLOW_configurationStatement_in_configuration28);
            	    configurationStatement(config);

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            match(input,EOF,FOLLOW_EOF_in_configuration34); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "configuration"


    // $ANTLR start "configurationStatement"
    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:15:1: configurationStatement[MiddlemanConfiguration config] : ( PORT EQ port= NUMBER | def= proxyDefinition );
    public final void configurationStatement(MiddlemanConfiguration config) throws RecognitionException {
        Token port=null;
        ProxyConfig def = null;


        try {
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:16:2: ( PORT EQ port= NUMBER | def= proxyDefinition )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==PORT) ) {
                alt2=1;
            }
            else if ( (LA2_0==PROXY) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:16:4: PORT EQ port= NUMBER
                    {
                    match(input,PORT,FOLLOW_PORT_in_configurationStatement45); if (state.failed) return ;
                    match(input,EQ,FOLLOW_EQ_in_configurationStatement47); if (state.failed) return ;
                    port=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_configurationStatement51); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       config.setConfigurationPort(Integer.parseInt(port.getText())); 
                    }

                    }
                    break;
                case 2 :
                    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:17:4: def= proxyDefinition
                    {
                    pushFollow(FOLLOW_proxyDefinition_in_configurationStatement60);
                    def=proxyDefinition();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       config.add(def); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "configurationStatement"


    // $ANTLR start "proxyDefinition"
    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:20:1: proxyDefinition returns [ProxyConfig proxy] : PROXY name= IDENTIFIER BEGIN ( proxyStatement[proxy] )* END ;
    public final ProxyConfig proxyDefinition() throws RecognitionException {
        ProxyConfig proxy = null;

        Token name=null;

         proxy = new ProxyConfig(); 
        try {
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:22:2: ( PROXY name= IDENTIFIER BEGIN ( proxyStatement[proxy] )* END )
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:22:4: PROXY name= IDENTIFIER BEGIN ( proxyStatement[proxy] )* END
            {
            match(input,PROXY,FOLLOW_PROXY_in_proxyDefinition81); if (state.failed) return proxy;
            name=(Token)match(input,IDENTIFIER,FOLLOW_IDENTIFIER_in_proxyDefinition85); if (state.failed) return proxy;
            if ( state.backtracking==0 ) {
              proxy.setName(name.getText());
            }
            match(input,BEGIN,FOLLOW_BEGIN_in_proxyDefinition88); if (state.failed) return proxy;
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:22:65: ( proxyStatement[proxy] )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==PORT||LA3_0==OUTPROXY||(LA3_0>=DEBUG && LA3_0<=STUB)) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:22:66: proxyStatement[proxy]
            	    {
            	    pushFollow(FOLLOW_proxyStatement_in_proxyDefinition91);
            	    proxyStatement(proxy);

            	    state._fsp--;
            	    if (state.failed) return proxy;

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,END,FOLLOW_END_in_proxyDefinition96); if (state.failed) return proxy;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return proxy;
    }
    // $ANTLR end "proxyDefinition"


    // $ANTLR start "proxyStatement"
    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:25:1: proxyStatement[ProxyConfig proxy] : ( PORT EQ port= NUMBER | OUTPROXY EQ outproxy= STRING | statement= stubStatement | DEBUG EQ debugLevel= NUMBER );
    public final void proxyStatement(ProxyConfig proxy) throws RecognitionException {
        Token port=null;
        Token outproxy=null;
        Token debugLevel=null;
        StubResponse statement = null;


        try {
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:26:2: ( PORT EQ port= NUMBER | OUTPROXY EQ outproxy= STRING | statement= stubStatement | DEBUG EQ debugLevel= NUMBER )
            int alt4=4;
            switch ( input.LA(1) ) {
            case PORT:
                {
                alt4=1;
                }
                break;
            case OUTPROXY:
                {
                alt4=2;
                }
                break;
            case STUB:
                {
                alt4=3;
                }
                break;
            case DEBUG:
                {
                alt4=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }

            switch (alt4) {
                case 1 :
                    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:26:4: PORT EQ port= NUMBER
                    {
                    match(input,PORT,FOLLOW_PORT_in_proxyStatement109); if (state.failed) return ;
                    match(input,EQ,FOLLOW_EQ_in_proxyStatement111); if (state.failed) return ;
                    port=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_proxyStatement115); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      proxy.setPort(Integer.parseInt(port.getText()));
                    }

                    }
                    break;
                case 2 :
                    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:27:4: OUTPROXY EQ outproxy= STRING
                    {
                    match(input,OUTPROXY,FOLLOW_OUTPROXY_in_proxyStatement122); if (state.failed) return ;
                    match(input,EQ,FOLLOW_EQ_in_proxyStatement124); if (state.failed) return ;
                    outproxy=(Token)match(input,STRING,FOLLOW_STRING_in_proxyStatement128); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      proxy.setOutgoingProxy(outproxy.getText());
                    }

                    }
                    break;
                case 3 :
                    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:28:4: statement= stubStatement
                    {
                    pushFollow(FOLLOW_stubStatement_in_proxyStatement137);
                    statement=stubStatement();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       proxy.add(statement); 
                    }

                    }
                    break;
                case 4 :
                    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:29:4: DEBUG EQ debugLevel= NUMBER
                    {
                    match(input,DEBUG,FOLLOW_DEBUG_in_proxyStatement144); if (state.failed) return ;
                    match(input,EQ,FOLLOW_EQ_in_proxyStatement146); if (state.failed) return ;
                    debugLevel=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_proxyStatement150); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      proxy.setDebugLevel(Integer.parseInt(debugLevel.getText())); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "proxyStatement"


    // $ANTLR start "stubStatement"
    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:34:1: stubStatement returns [StubResponse stub] : STUB url= HOSTNAME BEGIN ( stubSetting[stub] )* END ;
    public final StubResponse stubStatement() throws RecognitionException {
        StubResponse stub = null;

        Token url=null;


        stub = new StubResponse();

        try {
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:38:3: ( STUB url= HOSTNAME BEGIN ( stubSetting[stub] )* END )
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:38:5: STUB url= HOSTNAME BEGIN ( stubSetting[stub] )* END
            {
            match(input,STUB,FOLLOW_STUB_in_stubStatement174); if (state.failed) return stub;
            url=(Token)match(input,HOSTNAME,FOLLOW_HOSTNAME_in_stubStatement178); if (state.failed) return stub;
            if ( state.backtracking==0 ) {
              stub.setUrl(url.getText()); 
            }
            match(input,BEGIN,FOLLOW_BEGIN_in_stubStatement181); if (state.failed) return stub;
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:38:60: ( stubSetting[stub] )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=STATUSCODE && LA5_0<=HEADER)||LA5_0==BODY) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:38:61: stubSetting[stub]
            	    {
            	    pushFollow(FOLLOW_stubSetting_in_stubStatement184);
            	    stubSetting(stub);

            	    state._fsp--;
            	    if (state.failed) return stub;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            match(input,END,FOLLOW_END_in_stubStatement189); if (state.failed) return stub;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return stub;
    }
    // $ANTLR end "stubStatement"


    // $ANTLR start "stubSetting"
    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:41:1: stubSetting[StubResponse stub] : ( STATUSCODE EQ statusCode= NUMBER | HEADER EQ header= BLOCK | BODY EQ body= BLOCK );
    public final void stubSetting(StubResponse stub) throws RecognitionException {
        Token statusCode=null;
        Token header=null;
        Token body=null;

        try {
            // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:42:2: ( STATUSCODE EQ statusCode= NUMBER | HEADER EQ header= BLOCK | BODY EQ body= BLOCK )
            int alt6=3;
            switch ( input.LA(1) ) {
            case STATUSCODE:
                {
                alt6=1;
                }
                break;
            case HEADER:
                {
                alt6=2;
                }
                break;
            case BODY:
                {
                alt6=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:42:4: STATUSCODE EQ statusCode= NUMBER
                    {
                    match(input,STATUSCODE,FOLLOW_STATUSCODE_in_stubSetting201); if (state.failed) return ;
                    match(input,EQ,FOLLOW_EQ_in_stubSetting203); if (state.failed) return ;
                    statusCode=(Token)match(input,NUMBER,FOLLOW_NUMBER_in_stubSetting207); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       stub.setStatusCode(statusCode.getText()); 
                    }

                    }
                    break;
                case 2 :
                    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:43:4: HEADER EQ header= BLOCK
                    {
                    match(input,HEADER,FOLLOW_HEADER_in_stubSetting214); if (state.failed) return ;
                    match(input,EQ,FOLLOW_EQ_in_stubSetting216); if (state.failed) return ;
                    header=(Token)match(input,BLOCK,FOLLOW_BLOCK_in_stubSetting220); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      stub.setHeader(header.getText()); 
                    }

                    }
                    break;
                case 3 :
                    // c:\\workspace\\middleman\\src\\middleman\\configuration\\Configuration.g:44:4: BODY EQ body= BLOCK
                    {
                    match(input,BODY,FOLLOW_BODY_in_stubSetting227); if (state.failed) return ;
                    match(input,EQ,FOLLOW_EQ_in_stubSetting229); if (state.failed) return ;
                    body=(Token)match(input,BLOCK,FOLLOW_BLOCK_in_stubSetting233); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                      stub.setBody(body.getText()); 
                    }

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "stubSetting"

    // Delegated rules


 

    public static final BitSet FOLLOW_configurationStatement_in_configuration28 = new BitSet(new long[]{0x0000000000000090L});
    public static final BitSet FOLLOW_EOF_in_configuration34 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PORT_in_configurationStatement45 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQ_in_configurationStatement47 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NUMBER_in_configurationStatement51 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_proxyDefinition_in_configurationStatement60 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PROXY_in_proxyDefinition81 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_IDENTIFIER_in_proxyDefinition85 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_BEGIN_in_proxyDefinition88 = new BitSet(new long[]{0x0000000000006C10L});
    public static final BitSet FOLLOW_proxyStatement_in_proxyDefinition91 = new BitSet(new long[]{0x0000000000006C10L});
    public static final BitSet FOLLOW_END_in_proxyDefinition96 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_PORT_in_proxyStatement109 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQ_in_proxyStatement111 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NUMBER_in_proxyStatement115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_OUTPROXY_in_proxyStatement122 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQ_in_proxyStatement124 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_STRING_in_proxyStatement128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_stubStatement_in_proxyStatement137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_DEBUG_in_proxyStatement144 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQ_in_proxyStatement146 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NUMBER_in_proxyStatement150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STUB_in_stubStatement174 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_HOSTNAME_in_stubStatement178 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_BEGIN_in_stubStatement181 = new BitSet(new long[]{0x00000000000B0400L});
    public static final BitSet FOLLOW_stubSetting_in_stubStatement184 = new BitSet(new long[]{0x00000000000B0400L});
    public static final BitSet FOLLOW_END_in_stubStatement189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STATUSCODE_in_stubSetting201 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQ_in_stubSetting203 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_NUMBER_in_stubSetting207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_HEADER_in_stubSetting214 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQ_in_stubSetting216 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_BLOCK_in_stubSetting220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_BODY_in_stubSetting227 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_EQ_in_stubSetting229 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_BLOCK_in_stubSetting233 = new BitSet(new long[]{0x0000000000000002L});

}