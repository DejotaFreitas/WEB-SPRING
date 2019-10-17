var navegacao = {

  elemento_corpo: null,

  init: function (id_corpo_site) {
    navegacao.elemento_corpo = document.getElementById(id_corpo_site);
    navegacao.navegar();
    navegacao.events();
  },

  pegar_url: function () {
    var url_atual = window.location.hash;
    var url = str = url_atual.substring(1);
    if (url) {
      return url;
    }
    return 'home'
  },

  navegar: function() {
    RequestAjaxAsync(
        function(resposta) {
          navegacao.elemento_corpo.innerHTML = resposta;
        }, navegacao.pegar_url()+".html");
  },

  events: function () {
    window.onhashchange = function() {
     navegacao.navegar();
   }
  }

};

navegacao.init('corpo');
