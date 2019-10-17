
// upload_img.init('if_img', 'img_view');

var upload_img = {

  input_file: null,
  img_show: null,

  init: function(input_id, img_id) {
    upload_img.input_file = document.getElementById(input_id);
    upload_img.img_show = document.getElementById(img_id);
    upload_img.events();
  },

  events: function() {
    upload_img.input_file.onchange = function(event) {
      var file = event.target.files[0];
      if (file) {
        var reader = new FileReader();
        reader.onload = function(event) {
          var img_result = event.target.result;
          upload_img.img_show.src = img_result;
        };
        reader.readAsDataURL(file);
      }
    }
  }

};
