import time
from statistics import mean

import nltk

from nltk.corpus import stopwords
from nltk.tokenize import word_tokenize, sent_tokenize

DEFAULT_LANG = "english"
WEIGHT_MODIFIER = 1.2

stop_words_dict = {DEFAULT_LANG: stopwords.words(DEFAULT_LANG)}


def text_summarizer(text, weight_mod=WEIGHT_MODIFIER, lang=DEFAULT_LANG):
    lang_lower = lang.lower()

    if lang_lower not in stop_words_dict:
        stop_words_dict.update({lang_lower: stopwords.words(lang_lower)})

    stop_words = stop_words_dict[lang_lower]

    sentences = sent_tokenize(text)
    words = word_tokenize(text.lower())

    word_freq = {word: words.count(word) for word in words if word not in stop_words}
    sent_val = {
        ea_sent: sum(
            [freq for word, freq in word_freq.items() if word in ea_sent.lower()]
        )
        for ea_sent in sentences
    }
    weighted_average = weight_mod * int(mean(sent_val.values()))

    summary = [ea_sent for ea_sent in sent_val if sent_val[ea_sent] > weighted_average]

    return (" ".join(summary)) if len(summary) > 0 else sentences[0]
