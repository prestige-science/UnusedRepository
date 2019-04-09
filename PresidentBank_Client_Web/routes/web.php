<?php

/*
|--------------------------------------------------------------------------
| Web Routes
|--------------------------------------------------------------------------
|
| Here is where you can register web routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| contains the "web" middleware group. Now create something great!
|
*/

Route::get('/', function () {
    return view('welcome');
});

Route::get('blog', 'BlogController@index');
Route::get('rika', 'RikaController@index');
Route::get('transfer/index', 'TransferController@index');
Route::get('transfer', 'TransferController@create');
Route::get('transfer', 'TransferController@edit');
Route::get('transfer', 'TransferController@update');
Route::get('transfer', 'TransferController@delete');

Route::get('pay-bill', 'PayBillController@index');
Route::get('pay-bill', 'PayBillController@create');
Route::get('pay-bill', 'PayBillController@edit');
Route::get('pay-bill', 'PayBillController@update');
Route::get('pay-bill', 'PayBillController@delete');

Route::get('sign/in', 'SignController@in');

Route::get('profile/in', 'ProfileController@in');

Route::get('dashboard/index', 'DashboardController@index');

Route::get('test/json', 'TestController@json');

Route::get('mutation', 'MutationController@index');




Auth::routes();

Route::get('/home', 'HomeController@index')->name('home');
