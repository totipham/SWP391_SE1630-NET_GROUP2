"use strict";

// Class definition
var KTFormRepeaterBasic = function () {
    // Private functions
    var example1 = function () {
        $('#utility-form-repeater').repeater({
            initEmpty: false,

            show: function () {
                var limitcount = $(this).parents(".repeater").data("limit");
                var itemcount = $(this).parents(".repeater").find("div[data-repeater-item]").length;

                if (limitcount) {
                    if (itemcount <= limitcount) {
                        $(this).slideDown();
                    } else {
                        alert("You can add only 5 utility fees for this property!");
                        $(this).remove();
                    }
                } else {
                    $(this).slideDown();
                }

                if (itemcount >= limitcount) {
                    $(".repeater input[data-repeater-create]").hide("slow");
                }
            },

            hide: function (deleteElement) {
                var limitcount = $(this).parents(".repeater").data("limit");
                var itemcount = $(this).parents(".repeater").find("div[data-repeater-item]").length;

                if (confirm('Are you sure you want to delete this element?')) {
                    $(this).slideUp(deleteElement);
                }

                if (itemcount <= limitcount) {
                    $(".repeater input[data-repeater-create]").show("slow");
                }
            }
        });
    }

    return {
        // Public Functions
        init: function () {
            example1();
        }
    };
}();

// On document ready
KTUtil.onDOMContentLoaded(function () {
    KTFormRepeaterBasic.init();
});
