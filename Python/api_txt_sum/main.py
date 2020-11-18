from typing import Optional

from fastapi import FastAPI
from pydantic import BaseModel

from sqlite_tools import doc_insert

app = FastAPI()


class Document(BaseModel):
    text: str
    document_id: Optional[int]
    summary: Optional[str]
    weight_mod: Optional[float]
    lang: Optional[str]


@app.post("/documents/")
async def create_item(document: Document):
    return doc_insert(
        document.text,
        document_id=document.document_id,
        summary=document.summary,
        lang=document.lang,
        weight_mod=document.weight_mod,
    )