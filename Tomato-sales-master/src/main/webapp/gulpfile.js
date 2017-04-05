var gulp = require('gulp');
var uglify = require('gulp-uglify');
var cleanCSS = require('gulp-clean-css');
var rename = require("gulp-rename");
var concat = require('gulp-concat');
var order = require("gulp-order");

/**
 * Tasks
 * -----
 */

/**
 * Minify CSS
 *
 * @source .css files
 * @dest .css files
 */
gulp.task('minify-css', function() {
    return gulp.src('css/**/*.css')
        .pipe(cleanCSS({compatibility: 'ie8'}))
        .pipe(rename({
            suffix: '.min'
        }))
        .pipe(gulp.dest('dist/css'));
});

/**
 * Minify JS
 *
 * @source .js files
 * @dest .js files
 */
gulp.task('minify-js', function(){
    gulp.src('app/**/*.js')
        .pipe(uglify({ mangle: false }))
        .pipe(rename({
            suffix: '.min'
        }))
        .pipe(gulp.dest('dist/js'));
});

/*
/!**
 * Bundle js files
 *
 * @source .js files
 * @dest .js files
 *!/

gulp.task('bundle', function() {
    return gulp.src('dist/js/!**!/!*js')
        .pipe(order([
            "app.min.js",
            "**!/!*.js"
        ]))
        .pipe(concat('bundle.js'))
        .pipe(gulp.dest('dist/js'));
});
*/

gulp.task('default', [
    'minify-css',
    'minify-js'
]);