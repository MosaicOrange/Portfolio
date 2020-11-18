
FastAPI & NLTK implementation
======
Technologies
------
This was built using python 3.8.6. Typically I would use conda, but for the sake of brevity and not knowing if the end users have conda installed, I decided to go without.

For the text summarizer, I decided to use [NLTK](https://www.nltk.org/) and I used a tutorial I found at GeeksForGeeks [here](https://www.geeksforgeeks.org/python-text-summarizer/). Some of the code is structured in a way as to show my ability to interpret and construct complicated comprehensions as well as using other tools within python to accomplish the same goals, but more cleanly than was done in the original tutorial.

For the web-framework I decided to use [FastAPI](https://fastapi.tiangolo.com) just because I had never used it before (and I was hoping that it would be fast to use). It was actually so easy to use that I got everything I needed by the time I reached the "Request Body" portion of the tutorial.

For document storage I used python's built-in sqlite3. I have some familiarity with this tool so I only had to rely on the [documentation](https://docs.python.org/3.8/library/sqlite3.html).

Lastly, I like to run code through [Black](https://github.com/psf/black). I believe in having consistent code design patterns, and that's easiest across a team when we all use the same code formatter with the same settings.


Tools
------
My favorite text editor of choice [Sublime Text](https://www.sublimetext.com/) and [Markdown Preview](https://facelessuser.github.io/MarkdownPreview) which helped me write this README. Also Firefox and terminal to view and execute things, respectively.


Design Choices
------
##### main.py
 * I wanted to give the ability for the endpoint to set the `document_id` and the `summary` without using the text summarizer. Since the table doesn't have primary keys, multiple entries could exist within the table without worrying about overwriting one another.
 * To further flesh out this project I would ask what are the end user goals of using these document ids and the planned use of the stored documents. I would mostly likely remove the ability to set the `document_id` when using the endpoint just to avoid confusion later on when retrieving the documents.

##### text_summerizer.py
 * Normally, I would not write the `sent_val` dictionary object as a double comprehension. For readability, I am a proponent of nothing being more than one list comprehension deep. I wrote it like this just to show my ability to use multiple nested comprehensions with clauses.
 * I used `count` to count words because it's cleaner and faster than using `for` loops.
 * I used `mean` from `statistics` just to be fancy.
 * I added a case for a situation where if all the sentences had relatively equal amount of weight then only  the first sentenced would be returned. In this case, I would ask further questions to the end users in order to have a better result.

##### sqlite_tools.py
 * I only went with sqlite3 because it was a quick and easy tool without having to run another server instance for SQL support. If I was to rewrite this I would probably go with a fully feature SQL platform, or some other tool that allows quick access to stored data.
 * I decided to write a simple context manager because using `with` statements allows me to make sure everything gets committed and closed.
 * For `doc_insert` I decided to check the current `max_document` id and just add one if it wasn't set initially, and the `summary` only uses the `text_summerizer` when it's not set either. 


Final Thoughts
------
I normally don't get exposed to too many new things at work so I had fun getting to learn about NLTK and FastAPI. 10 out 10, would do it again.


Instructions
------
This assumes that the user has conda already installed and updated as this uses conda to create the virtual environment. After unzipping, `cd` into the directory and run:
```
conda env update -f api_txt_sum.yaml
conda activate api_txt_sum
```

To deactivate, simply
```
conda deactivate
```

Run the following to ensure nltk libraries are available for use. This simply downloads `stopwords` and `punkt` and only needs to happen once.
```
python setup.py
```

At this point, if you already have a `documents.db` file you can either keep it, or delete it if you want a fresh start.

To run the server, execute
```
uvicorn main:app
```

Try it in English with
```
curl -X POST "http://127.0.0.1:8000/documents/" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{\"text\":\"There are many techniques available to generate extractive summarization to keep it simple, I will be using an unsupervised learning approach to find the sentences similarity and rank them. Summarization can be defined as a task of producing a concise and fluent summary while preserving key information and overall meaning. One benefit of this will be, you don’t need to train and build a model prior start using it for your project. It’s good to understand Cosine similarity to make the best use of the code you are going to see. Cosine similarity is a measure of similarity between two non-zero vectors of an inner product space that measures the cosine of the angle between them. Its measures cosine of the angle between vectors. The angle will be 0 if sentences are similar.\"}"
```

Which will return if no other documents are within the database
```
[0,"There are many techniques available to generate extractive summarization to keep it simple, I will be using an unsupervised learning approach to find the sentences similarity and rank them. Cosine similarity is a measure of similarity between two non-zero vectors of an inner product space that measures the cosine of the angle between them."]
```

Try it in Spanish with
```
curl -X POST "http://127.0.0.1:8000/documents/" -H  "accept: application/json" -H  "Content-Type: application/json" -d "{\"text\":\"Formas curvas, construcciones fuera de lo común, metáforas a través de los edificios … En España vas a encontrar numerosos ejemplos de una arquitectura moderna que inspira tiempos futuristas. Te descubrimos algunos de los que puedes conocer en el norte de España si visitas las regiones de Asturias, Cantabria, Galicia y País Vasco. Es la zona conocida como España Verde debido a la riqueza de su entorno natural. Las 33.000 planchas de titanio de este edificio y sus formas curvilíneas parecen desafiar a la lógica y sorprenden al viajero que se acerca a la ribera de la ría del Nervión. El arquitecto Frank Gehry ha conseguido que el Guggenheim se convierta en el icono más reconocible de la ciudad de Bilbao y en uno de los museos más bonitos del mundo. Se trata de la única obra del arquitecto brasileño Oscar Niemeyer en España. En contraste con el casco histórico de Avilés, es pura vanguardia. Grandes superficies blancas y formas curvas cautivan la mirada y son la carta de presentación de un auditorio, una torre mirador o una cúpula espectaculares. “Un animal galopando por el campo” era la idea del arquitecto Frank Gehry con este proyecto que se ha consolidado como una de las grandes catedrales del vino en España. Un edificio sorprendente sobre todo por su cubierta de curvas y extrañas formas con placas de titanio de los colores propios del caldo que lucen rodeadas entre viñedos. La cima del monte Gaiás, en Santiago de Compostela, cambió radicalmente con este proyecto. El arquitecto Peter Eisenman ha dado vida a una serie de edificios singulares que se inspiran en las rutas de peregrinación de la ciudad medieval. Los visitantes pueden recorrer los exteriores, apuntarse a una visita guiada o asistir a alguna de las exposiciones o conciertos que se organizan. Es el más “joven” de los edificios que te hemos propuesto. Se trata de un centro de arte diseñado por Renzo Piano en plena bahía de Santander e inaugurado en 2017. Una ubicación espectacular para un edificio cubierto por 270.000 piezas cerámicas que parece suspenderse sobre el mar como si de un muelle se tratara. Acoge exposiciones y diferentes propuestas culturales. Sostenible, respetuoso con su entorno, bonito y práctico. Este polideportivo, estadio de baloncesto y palacio de congresos es un ejemplo de la arquitectura moderna más responsable. Reutiliza el agua de la lluvia, incorpora cogeneración energética y se integra en la naturaleza que lo rodea con un diseño que reproduce la roca de la antigua explotación minera y la arbolada de la zona. Dos grandes cubos de vidrio translucidos que emulan dos grandes rocas varadas frente al mar. Así se presenta esta obra de Rafael Moneo, reconocida con el premio de arquitectura contemporánea Mies Van de Rohe, y que puede presumir de integración con la naturaleza. Su silueta frente al litoral cuando se ilumina al caer la noche, te dará una de las mejores fotos de la ciudad. Puedes consultar otros ejemplos en nuestro folleto de arquitectura contemporánea en España.\",\"lang\":\"spanish\"}"
```
Which will return if you ran the previous command
```
[1,"Te descubrimos algunos de los que puedes conocer en el norte de España si visitas las regiones de Asturias, Cantabria, Galicia y País Vasco. “Un animal galopando por el campo” era la idea del arquitecto Frank Gehry con este proyecto que se ha consolidado como una de las grandes catedrales del vino en España. Un edificio sorprendente sobre todo por su cubierta de curvas y extrañas formas con placas de titanio de los colores propios del caldo que lucen rodeadas entre viñedos. Los visitantes pueden recorrer los exteriores, apuntarse a una visita guiada o asistir a alguna de las exposiciones o conciertos que se organizan. Reutiliza el agua de la lluvia, incorpora cogeneración energética y se integra en la naturaleza que lo rodea con un diseño que reproduce la roca de la antigua explotación minera y la arbolada de la zona. Así se presenta esta obra de Rafael Moneo, reconocida con el premio de arquitectura contemporánea Mies Van de Rohe, y que puede presumir de integración con la naturaleza."] 
```
------