<%-- 
    Document   : footer
    Created on : Jun 19, 2022, 1:02:30 AM
    Author     : totipham
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<footer class="p-4 bg-gray-900 shadow md:px-6 md:py-8 mt-10">
    <div class="sm:flex sm:items-center sm:justify-between">
        <a href="${baseURL}" class="flex items-center mb-4 sm:mb-0">
            <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Hostalpy</span>
        </a>
        <ul class="flex flex-wrap items-center mb-6 text-sm text-gray-500 sm:mb-0 dark:text-gray-400">
            <li>
                <a href="#" class="mr-4 hover:underline md:mr-6 ">About</a>
            </li>
            <li>
                <a href="#" class="mr-4 hover:underline md:mr-6">Privacy Policy</a>
            </li>
            <li>
                <a href="#" class="mr-4 hover:underline md:mr-6 ">Licensing</a>
            </li>
            <li>
                <a href="#" class="hover:underline">Contact</a>
            </li>
        </ul>
    </div>
    <hr class="my-6 border-gray-200 sm:mx-auto dark:border-gray-700 lg:my-8">
    <span class="block text-sm text-gray-500 sm:text-center dark:text-gray-400">© 2022 <a href="${baseURL}" class="hover:underline">Hostalpy</a>. All Rights Reserved.
    </span>
</footer>
