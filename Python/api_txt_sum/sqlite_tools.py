import sqlite3
from contextlib import contextmanager

from text_summerizer import text_summarizer

SQL_DB = "documents.db"


@contextmanager
def sql_conn(dbpath):
    conn = sqlite3.connect(dbpath)
    try:
        cur = conn.cursor()
        yield cur
    except sqlite3.Error as conn_err:
        print("A sqlite connection error occurred:", e.args[0])
    else:
        conn.commit()
    finally:
        conn.close()


with sql_conn(SQL_DB) as cur:
    cur.execute(
        "CREATE TABLE IF NOT EXISTS documents (document_id INTEGER, text BLOB, summary TEXT, lang TEXT, weight_mod REAL)"
    )


def doc_insert(text, document_id=None, summary=None, lang=None, weight_mod=None):
    with sql_conn(SQL_DB) as cur:
        if not document_id:
            max_id = cur.execute("select max(document_id) from documents").fetchone()[0]
            document_id = 0 if max_id is None else max_id + 1
        if not summary:
            summary = text_summarizer(text)
        cur.execute(
            f"INSERT INTO documents VALUES (?,?,?,?,?)",
            (document_id, text, summary, lang, weight_mod),
        )
    return document_id, summary
