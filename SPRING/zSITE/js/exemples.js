window.location.href = "admin";

// =============================================================================

location.reload();

// =============================================================================

if (document.getElementById('formulario')) {

}

// =============================================================================

function add_anime(id, nome, imagem) {
  var img = document.createElement('img');
  img.src = imagem;
  var div_img = document.createElement('div');
  div_img.className = "imagem";
  div_img.appendChild(img);

  var p = document.createElement('p');
  var texto_nome = document.createTextNode(nome);       // Create a text node
  p.appendChild(texto_nome);
  var div_nome = document.createElement('div');
  div_nome.className = "nome";
  div_nome.appendChild(p);

  var div_anime = document.createElement('div');
  div_anime.className = "anime";
  div_anime.appendChild(div_img);
  div_anime.appendChild(div_nome);

  var a = document.createElement('a');
  a.href = "anime;animepisodio/"+id;
  a.appendChild(div_anime);

  animes_div.appendChild(a);
}

// =============================================================================

function add_anime(id, numero, nome_anime, nome, imagem) {

  var t = document.createElement('p');
  var texto_titulo = document.createTextNode(nome_anime);       // Create a text node
  t.appendChild(texto_titulo);
  var div_titulo = document.createElement('div');
  div_titulo.className = "titulo";
  div_titulo.appendChild(t);

  var img = document.createElement('img');
  img.src = imagem;
  var div_img = document.createElement('div');
  div_img.className = "imagem";
  div_img.appendChild(img);

  var p = document.createElement('p');
  var texto_nome = document.createTextNode(numero+" - "+nome);       // Create a text node
  p.appendChild(texto_nome);
  var div_nome = document.createElement('div');
  div_nome.className = "nome";
  div_nome.appendChild(p);

  var div_anime = document.createElement('div');
  div_anime.className = "anime";
  div_anime.appendChild(div_titulo);
  div_anime.appendChild(div_img);
  div_anime.appendChild(div_nome);

  var a = document.createElement('a');
  a.href = "anime;animepisodio/"+id+"/"+numero;
  a.appendChild(div_anime);

  animes_div.appendChild(a);
}
