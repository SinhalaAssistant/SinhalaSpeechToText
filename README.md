# SinhalaSpeechToText

Download - 

sphinxbase-5prealpha - https://bit.ly/2AWXsfF
pocketsphinx-5prealpha - https://bit.ly/2qEIzsx
sphinxtrain-5prealpha - https://bit.ly/2DzxBgB
sphinx4-5prealpha - https://bit.ly/2DcoKjI

Installation guide- https://cmusphinx.github.io/wiki/tutorialam/

Order to compile - Base, Pocket, Train

Perl older version is required. Preferably below 5.22
Wav must be 16K hz and 16 bit 
/etc contain important files - docs explains that

Sphinx_train.cfg has configurations can configure as explained in docs

In case of installing new dependencies such as audio libraries in OS recompile the base

Train- sphinxtrain run
Model/sphinxtrain-5prealpha/scripts/sphinxtrain has the file execution script
Decode - sphinxtrain -s decode run
Html contains error logs

Default acoustic model is at /usr/local/share/pocketsphinx/model/en-us/en-us

Live Recognition -  sudo pocketsphinx_continuous -inmic yes -hmm ../model_parameters/sinhala_bank.ci_semi -lm ../etc/sinhala_bank.lm -dict ../etc/sinhala_bank.dic
(sudo pockethinx_continuous -inmic yes -hmm accousticFolder -lm languagemodel -dict dictionary

From File- 

sudo pocketsphinx_continuous -infile ../wav/new.wav -hmm ../model_parameters/sinhala_bank.ci_semi -lm ../etc/sinhala_bank.lm -dict ../etc/sinhala_bank.dic

Python - 

https://pypi.org/project/pocketsphinx/

JAVA - 

Possible error of audio libraries - 

https://stackoverflow.com/questions/17132192/pocketsphinx-continuous-failed-to-open-audio-device

alsa
And recompile base

Decoder Error- 
As you train a small context-independent model, you should use it in decoding, too.
To put it simple, in your config file:
$DEC_CFG_MODEL_NAME = "$CFG_EXPTNAME.cd_${CFG_DIRLABEL}_${CFG_N_TIED_STATES}";
should be
$DEC_CFG_MODEL_NAME = "$CFG_EXPTNAME.ci_${CFG_DIRLABEL}";
By the way, when you have more data, it is better to re-train the model, not adapt this one.
Also you are right, I do not believe you can adapt english model for greek - it is completely different phonologically. So, you are on the right track


Useful - 
https://sourceforge.net/p/cmusphinx/discussion/help/thread/9d9b5749/

http://www.speech.cs.cmu.edu/sphinx/tutorial.html






